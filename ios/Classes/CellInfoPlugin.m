#import "CellInfoPlugin.h"
#import <CoreTelephony/CTTelephonyNetworkInfo.h>
#import <CoreTelephony/CTCarrier.h>

// Key used to cache the last cell_info response, mirroring the Android plugin.
static NSString *const kCellsInfoResponseKey = @"cells_info_response";

@implementation CellInfoPlugin

+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  CellInfoPlugin* instance = [[CellInfoPlugin alloc] init];

  // The plugin exposes the same three channels as the Android implementation.
  FlutterMethodChannel* cellInfoChannel =
      [FlutterMethodChannel methodChannelWithName:@"cell_info"
                                  binaryMessenger:[registrar messenger]];
  [registrar addMethodCallDelegate:instance channel:cellInfoChannel];

  FlutterMethodChannel* simInfoChannel =
      [FlutterMethodChannel methodChannelWithName:@"sim_info"
                                  binaryMessenger:[registrar messenger]];
  [registrar addMethodCallDelegate:instance channel:simInfoChannel];

  FlutterMethodChannel* sharedPreferenceChannel =
      [FlutterMethodChannel methodChannelWithName:@"shared_preference"
                                  binaryMessenger:[registrar messenger]];
  [registrar addMethodCallDelegate:instance channel:sharedPreferenceChannel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"cell_info" isEqualToString:call.method]) {
    NSString *json = [self cellInfoJson];
    // Cache so the shared_preference channel can return the last known value.
    [[NSUserDefaults standardUserDefaults] setObject:json forKey:kCellsInfoResponseKey];
    result(json);
  } else if ([@"sim_info" isEqualToString:call.method]) {
    result([self simInfoJson]);
  } else if ([@"shared_preference" isEqualToString:call.method]) {
    result([[NSUserDefaults standardUserDefaults] stringForKey:kCellsInfoResponseKey]);
  } else {
    result(FlutterMethodNotImplemented);
  }
}

#pragma mark - SIM info

// Returns a SIMInfoResponse-shaped JSON string: { "simInfoList": [ ... ] }.
//
// iOS only exposes carrier identity (name / MCC / MNC) and never the
// subscriber phone number, so `subscriptionInfoNumber` is always null.
// Note: CTCarrier is deprecated since iOS 16 and returns placeholder values
// ("--", "65535") on newer systems — this is an Apple platform limitation.
- (NSString *)simInfoJson {
  NSMutableArray *simInfoList = [NSMutableArray array];

  CTTelephonyNetworkInfo *networkInfo = [[CTTelephonyNetworkInfo alloc] init];
  NSDictionary<NSString *, CTCarrier *> *carriers = [self carriersForNetworkInfo:networkInfo];

  for (CTCarrier *carrier in carriers.allValues) {
    if (carrier == nil) {
      continue;
    }
    NSMutableDictionary *sim = [NSMutableDictionary dictionary];
    sim[@"carrierName"] = [self stringOrNull:carrier.carrierName];
    // displayName has no iOS equivalent; reuse the carrier name for parity.
    sim[@"displayName"] = [self stringOrNull:carrier.carrierName];
    // The Dart model types mcc/mnc as int, so emit numbers (or null).
    sim[@"mcc"] = [self numberFromString:carrier.mobileCountryCode];
    sim[@"mnc"] = [self numberFromString:carrier.mobileNetworkCode];
    sim[@"subscriptionInfoNumber"] = [NSNull null];
    [simInfoList addObject:sim];
  }

  return [self jsonStringFromObject:@{@"simInfoList" : simInfoList}];
}

#pragma mark - Cell info

// Returns a CellsResponse-shaped JSON string. iOS has no public API for cell
// identity, signal strength or neighbouring cells, so the only data available
// is the current radio access technology per SIM, surfaced as a primary cell.
- (NSString *)cellInfoJson {
  NSMutableArray *primaryCellList = [NSMutableArray array];
  NSMutableArray *cellDataList = [NSMutableArray array];

  CTTelephonyNetworkInfo *networkInfo = [[CTTelephonyNetworkInfo alloc] init];
  NSDictionary<NSString *, CTCarrier *> *carriers = [self carriersForNetworkInfo:networkInfo];
  NSDictionary<NSString *, NSString *> *rats = [self radioAccessTechnologiesForNetworkInfo:networkInfo];

  for (NSString *serviceId in rats.allKeys) {
    NSString *type = [self normalizedTypeForRadioAccessTechnology:rats[serviceId]];
    if (type == nil) {
      continue;
    }
    CTCarrier *carrier = carriers[serviceId];

    NSDictionary *cellType = [self cellTypeDictForType:type carrier:carrier];
    [primaryCellList addObject:cellType];

    [cellDataList addObject:@{
      @"latitude" : [NSNull null],
      @"longitude" : [NSNull null],
      @"type" : type,
      @"dbm" : [NSNull null],
    }];
  }

  return [self jsonStringFromObject:@{
    @"neighboringCellList" : @[],
    @"primaryCellList" : primaryCellList,
    @"cellDataList" : cellDataList,
  }];
}

// Builds a CellType entry with the technology-specific nested object populated
// with the carrier network (iso/mcc/mnc). Signal and identity fields are
// omitted because iOS does not expose them.
- (NSDictionary *)cellTypeDictForType:(NSString *)type carrier:(CTCarrier *)carrier {
  NSMutableDictionary *inner = [NSMutableDictionary dictionary];
  inner[@"type"] = type;
  inner[@"connectionStatus"] = @"PrimaryConnection";
  if (carrier != nil) {
    inner[@"network"] = @{
      @"iso" : [self stringOrNull:carrier.isoCountryCode],
      @"mcc" : [self stringOrNull:carrier.mobileCountryCode],
      @"mnc" : [self stringOrNull:carrier.mobileNetworkCode],
    };
  }

  // Map the type to the matching key in the CellType Dart model.
  static NSDictionary *keyForType;
  static dispatch_once_t onceToken;
  dispatch_once(&onceToken, ^{
    keyForType = @{
      @"LTE" : @"lte",
      @"NR" : @"nr",
      @"WCDMA" : @"wcdma",
      @"GSM" : @"gsm",
      @"CDMA" : @"cdma",
      @"TDSCDMA" : @"tdscdma",
    };
  });

  NSMutableDictionary *cellType = [NSMutableDictionary dictionary];
  cellType[@"type"] = type;
  NSString *key = keyForType[type];
  if (key != nil) {
    cellType[key] = inner;
  }
  return cellType;
}

#pragma mark - CoreTelephony helpers

// Returns the per-service carriers, falling back to the single-SIM API on
// older iOS versions. Deprecation warnings are expected — these are the only
// public APIs Apple provides.
- (NSDictionary<NSString *, CTCarrier *> *)carriersForNetworkInfo:(CTTelephonyNetworkInfo *)networkInfo {
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"
  if (@available(iOS 12.0, *)) {
    NSDictionary<NSString *, CTCarrier *> *providers = networkInfo.serviceSubscriberCellularProviders;
    if (providers != nil) {
      return providers;
    }
  }
  CTCarrier *carrier = networkInfo.subscriberCellularProvider;
  return carrier != nil ? @{@"0" : carrier} : @{};
#pragma clang diagnostic pop
}

- (NSDictionary<NSString *, NSString *> *)radioAccessTechnologiesForNetworkInfo:(CTTelephonyNetworkInfo *)networkInfo {
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"
  if (@available(iOS 12.0, *)) {
    NSDictionary<NSString *, NSString *> *rats = networkInfo.serviceCurrentRadioAccessTechnology;
    if (rats != nil) {
      return rats;
    }
  }
  NSString *rat = networkInfo.currentRadioAccessTechnology;
  return rat != nil ? @{@"0" : rat} : @{};
#pragma clang diagnostic pop
}

// Maps a CoreTelephony radio access technology constant to the network family
// strings used by the Android implementation.
- (NSString *)normalizedTypeForRadioAccessTechnology:(NSString *)rat {
  if (rat == nil) {
    return nil;
  }
  if ([rat isEqualToString:CTRadioAccessTechnologyLTE]) {
    return @"LTE";
  }
  if (@available(iOS 14.1, *)) {
    if ([rat isEqualToString:CTRadioAccessTechnologyNR] ||
        [rat isEqualToString:CTRadioAccessTechnologyNRNSA]) {
      return @"NR";
    }
  }
  if ([rat isEqualToString:CTRadioAccessTechnologyWCDMA] ||
      [rat isEqualToString:CTRadioAccessTechnologyHSDPA] ||
      [rat isEqualToString:CTRadioAccessTechnologyHSUPA]) {
    return @"WCDMA";
  }
  if ([rat isEqualToString:CTRadioAccessTechnologyGPRS] ||
      [rat isEqualToString:CTRadioAccessTechnologyEdge]) {
    return @"GSM";
  }
  if ([rat isEqualToString:CTRadioAccessTechnologyCDMA1x] ||
      [rat isEqualToString:CTRadioAccessTechnologyCDMAEVDORev0] ||
      [rat isEqualToString:CTRadioAccessTechnologyCDMAEVDORevA] ||
      [rat isEqualToString:CTRadioAccessTechnologyCDMAEVDORevB] ||
      [rat isEqualToString:CTRadioAccessTechnologyeHRPD]) {
    return @"CDMA";
  }
  return nil;
}

#pragma mark - JSON helpers

- (id)stringOrNull:(NSString *)value {
  return value.length > 0 ? value : (id)[NSNull null];
}

- (id)numberFromString:(NSString *)value {
  if (value.length == 0) {
    return [NSNull null];
  }
  NSNumberFormatter *formatter = [[NSNumberFormatter alloc] init];
  formatter.numberStyle = NSNumberFormatterNoStyle;
  NSNumber *number = [formatter numberFromString:value];
  return number != nil ? number : (id)[NSNull null];
}

- (NSString *)jsonStringFromObject:(id)object {
  NSError *error = nil;
  NSData *data = [NSJSONSerialization dataWithJSONObject:object options:0 error:&error];
  if (data == nil) {
    return @"{}";
  }
  return [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
}

@end
