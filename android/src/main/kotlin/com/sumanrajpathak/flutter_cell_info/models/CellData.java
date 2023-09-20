package com.sumanrajpathak.flutter_cell_info.models;

import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class CellData implements Serializable {

    private String user_id;
    private long timestamp;
    private String type;
    private Integer subscriptionId;
    private String connectionStatus;
    private String mcc;
    private String mnc;
    private String iso;
    private Integer sid;
    private Integer nid;
    private Integer bid;
    private Double latitude;
    private Double longitude;
    private Double lat;
    private Double lon;
    private int bandChannelNumber;
    private int bandNumber;
    private String bandName;
    private int cdmaRssi;
    private int evdoRssi;
    private int evdoSnr;
    private double cdmaEcio;
    private double evdoEcio;
    private Integer cid;
    private Integer lac;
    private Integer bsic;
    private Integer ncc;
    private Integer bcc;
    private Integer cgi;
    private int dbm;
    private int rssi;
    private int bitErrorRate;
    private int timingAdvance;
    private Integer bandwidth;
    private Integer eci;
    private Integer tac;
    private Integer pci;
    private Integer enb;
    private String ecgi;
    private int downlinkEarfcn;
    private double rsrp;
    private double rsrq;
    private double snr;
    private int cqi;
    private int rssiAsu;
    private int rsrpAsu;
    private Long nci;
    private int bandDownlinkArfcn;
    private int bandDownlinkFrequency;
    private int csiRsrp;
    private int csiRsrq;
    private int csiSinr;
    private int ssRsrp;
    private int ssRsrq;
    private int ssSinr;
    private int csiRsrpAsu;
    private int ssRsrpAsu;
    private Integer ci;
    private Integer cpid;
    private Integer rnc;
    private int downlinkUarfcn;
    private int rscp;
    private int rscpAsu;
    private Integer psc;
    private int ecno;
    private int ecio;
    private int arfcn;

    private String OSVERSION = System.getProperty("os.version");
    private String RELEASE = android.os.Build.VERSION.RELEASE;
    private String DEVICE = android.os.Build.DEVICE;
    private String MODEL = android.os.Build.MODEL;
    private String PRODUCT = android.os.Build.PRODUCT;
    private String BRAND = android.os.Build.BRAND;
    private String DISPLAY = android.os.Build.DISPLAY;
    private String CPU_ABI = android.os.Build.CPU_ABI;
    private String CPU_ABI2 = android.os.Build.CPU_ABI2;
    private String UNKNOWN = android.os.Build.UNKNOWN;
    private String HARDWARE = android.os.Build.HARDWARE;
    private String ID = android.os.Build.ID;
    private String MANUFACTURER = android.os.Build.MANUFACTURER;
    private String SERIAL = android.os.Build.SERIAL;
    private String USER = android.os.Build.USER;
    private String HOST = android.os.Build.HOST;

    public CellData() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public int getBandChannelNumber() {
        return bandChannelNumber;
    }

    public void setBandChannelNumber(int bandChannelNumber) {
        this.bandChannelNumber = bandChannelNumber;
    }

    public int getBandNumber() {
        return bandNumber;
    }

    public void setBandNumber(int bandNumber) {
        this.bandNumber = bandNumber;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getCdmaRssi() {
        return cdmaRssi;
    }

    public void setCdmaRssi(int cdmaRssi) {
        this.cdmaRssi = cdmaRssi;
    }

    public int getEvdoRssi() {
        return evdoRssi;
    }

    public void setEvdoRssi(int evdoRssi) {
        this.evdoRssi = evdoRssi;
    }

    public int getEvdoSnr() {
        return evdoSnr;
    }

    public void setEvdoSnr(int evdoSnr) {
        this.evdoSnr = evdoSnr;
    }

    public double getCdmaEcio() {
        return cdmaEcio;
    }

    public void setCdmaEcio(double cdmaEcio) {
        this.cdmaEcio = cdmaEcio;
    }

    public double getEvdoEcio() {
        return evdoEcio;
    }

    public void setEvdoEcio(double evdoEcio) {
        this.evdoEcio = evdoEcio;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getBsic() {
        return bsic;
    }

    public void setBsic(Integer bsic) {
        this.bsic = bsic;
    }

    public Integer getNcc() {
        return ncc;
    }

    public void setNcc(Integer ncc) {
        this.ncc = ncc;
    }

    public Integer getBcc() {
        return bcc;
    }

    public void setBcc(Integer bcc) {
        this.bcc = bcc;
    }

    public Integer getCgi() {
        return cgi;
    }

    public void setCgi(Integer cgi) {
        this.cgi = cgi;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getBitErrorRate() {
        return bitErrorRate;
    }

    public void setBitErrorRate(int bitErrorRate) {
        this.bitErrorRate = bitErrorRate;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getEci() {
        return eci;
    }

    public void setEci(Integer eci) {
        this.eci = eci;
    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public Integer getPci() {
        return pci;
    }

    public void setPci(Integer pci) {
        this.pci = pci;
    }

    public Integer getEnb() {
        return enb;
    }

    public void setEnb(Integer enb) {
        this.enb = enb;
    }

    public String getEcgi() {
        return ecgi;
    }

    public void setEcgi(String ecgi) {
        this.ecgi = ecgi;
    }

    public int getDownlinkEarfcn() {
        return downlinkEarfcn;
    }

    public void setDownlinkEarfcn(int downlinkEarfcn) {
        this.downlinkEarfcn = downlinkEarfcn;
    }

    public double getRsrp() {
        return rsrp;
    }

    public void setRsrp(double rsrp) {
        this.rsrp = rsrp;
    }

    public double getRsrq() {
        return rsrq;
    }

    public void setRsrq(double rsrq) {
        this.rsrq = rsrq;
    }

    public double getSnr() {
        return snr;
    }

    public void setSnr(double snr) {
        this.snr = snr;
    }

    public int getCqi() {
        return cqi;
    }

    public void setCqi(int cqi) {
        this.cqi = cqi;
    }

    public int getRssiAsu() {
        return rssiAsu;
    }

    public void setRssiAsu(int rssiAsu) {
        this.rssiAsu = rssiAsu;
    }

    public int getRsrpAsu() {
        return rsrpAsu;
    }

    public void setRsrpAsu(int rsrpAsu) {
        this.rsrpAsu = rsrpAsu;
    }

    public Long getNci() {
        return nci;
    }

    public void setNci(Long nci) {
        this.nci = nci;
    }

    public int getBandDownlinkArfcn() {
        return bandDownlinkArfcn;
    }

    public void setBandDownlinkArfcn(int bandDownlinkArfcn) {
        this.bandDownlinkArfcn = bandDownlinkArfcn;
    }

    public int getBandDownlinkFrequency() {
        return bandDownlinkFrequency;
    }

    public void setBandDownlinkFrequency(int bandDownlinkFrequency) {
        this.bandDownlinkFrequency = bandDownlinkFrequency;
    }

    public int getCsiRsrp() {
        return csiRsrp;
    }

    public void setCsiRsrp(int csiRsrp) {
        this.csiRsrp = csiRsrp;
    }

    public int getCsiRsrq() {
        return csiRsrq;
    }

    public void setCsiRsrq(int csiRsrq) {
        this.csiRsrq = csiRsrq;
    }

    public int getCsiSinr() {
        return csiSinr;
    }

    public void setCsiSinr(int csiSinr) {
        this.csiSinr = csiSinr;
    }

    public int getSsRsrp() {
        return ssRsrp;
    }

    public void setSsRsrp(int ssRsrp) {
        this.ssRsrp = ssRsrp;
    }

    public int getSsRsrq() {
        return ssRsrq;
    }

    public void setSsRsrq(int ssRsrq) {
        this.ssRsrq = ssRsrq;
    }

    public int getSsSinr() {
        return ssSinr;
    }

    public void setSsSinr(int ssSinr) {
        this.ssSinr = ssSinr;
    }

    public int getCsiRsrpAsu() {
        return csiRsrpAsu;
    }

    public void setCsiRsrpAsu(int csiRsrpAsu) {
        this.csiRsrpAsu = csiRsrpAsu;
    }

    public int getSsRsrpAsu() {
        return ssRsrpAsu;
    }

    public void setSsRsrpAsu(int ssRsrpAsu) {
        this.ssRsrpAsu = ssRsrpAsu;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getRnc() {
        return rnc;
    }

    public void setRnc(Integer rnc) {
        this.rnc = rnc;
    }

    public int getDownlinkUarfcn() {
        return downlinkUarfcn;
    }

    public void setDownlinkUarfcn(int downlinkUarfcn) {
        this.downlinkUarfcn = downlinkUarfcn;
    }

    public int getRscp() {
        return rscp;
    }

    public void setRscp(int rscp) {
        this.rscp = rscp;
    }

    public int getRscpAsu() {
        return rscpAsu;
    }

    public void setRscpAsu(int rscpAsu) {
        this.rscpAsu = rscpAsu;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    public int getEcno() {
        return ecno;
    }

    public void setEcno(int ecno) {
        this.ecno = ecno;
    }

    public int getEcio() {
        return ecio;
    }

    public void setEcio(int ecio) {
        this.ecio = ecio;
    }

    public int getArfcn() {
        return arfcn;
    }

    public void setArfcn(int arfcn) {
        this.arfcn = arfcn;
    }

    public String getOSVERSION() {
        return OSVERSION;
    }

    public void setOSVERSION(String OSVERSION) {
        this.OSVERSION = OSVERSION;
    }

    public String getRELEASE() {
        return RELEASE;
    }

    public void setRELEASE(String RELEASE) {
        this.RELEASE = RELEASE;
    }

    public String getDEVICE() {
        return DEVICE;
    }

    public void setDEVICE(String DEVICE) {
        this.DEVICE = DEVICE;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getPRODUCT() {
        return PRODUCT;
    }

    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getDISPLAY() {
        return DISPLAY;
    }

    public void setDISPLAY(String DISPLAY) {
        this.DISPLAY = DISPLAY;
    }

    public String getCPU_ABI() {
        return CPU_ABI;
    }

    public void setCPU_ABI(String CPU_ABI) {
        this.CPU_ABI = CPU_ABI;
    }

    public String getCPU_ABI2() {
        return CPU_ABI2;
    }

    public void setCPU_ABI2(String CPU_ABI2) {
        this.CPU_ABI2 = CPU_ABI2;
    }

    public String getUNKNOWN() {
        return UNKNOWN;
    }

    public void setUNKNOWN(String UNKNOWN) {
        this.UNKNOWN = UNKNOWN;
    }

    public String getHARDWARE() {
        return HARDWARE;
    }

    public void setHARDWARE(String HARDWARE) {
        this.HARDWARE = HARDWARE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public void setMANUFACTURER(String MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }

    public String getSERIAL() {
        return SERIAL;
    }

    public void setSERIAL(String SERIAL) {
        this.SERIAL = SERIAL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }
}
