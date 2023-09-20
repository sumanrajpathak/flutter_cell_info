#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint cell_info.podspec` to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'flutter_cell_info'
  s.version          = '0.0.5'
  s.summary          = 'Cell Info Plugin'
  s.description      = 'Cell Info Plugin'
  s.homepage         = 'http://devsumanrazz/flutter_cell_info'
  s.license          = { :file => '../LICENSE' }
  s.license       = { :type => 'BSD' }
  s.author           = { ' Company' => 'pathaksumanraj@gmail.com' }
  s.source           = { :git => 'http://devsumanrazz/flutter_cell_info.git' }
  
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'Flutter'
  s.platform = :ios, '11.0'
  s.ios.deployment_target  = '11.0'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
end
