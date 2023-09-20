package com.airfore.cell_info.models.lte;

import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Signal;

import java.io.Serializable;
@Keep
public class SignalLTE extends Signal implements Serializable {
    private int rssi;
    private double rsrp;
    private double rsrq;
    private double snr;
    private int cqi;
    private int timingAdvance;
    private int rssiAsu;
    private int rsrpAsu;

    public SignalLTE() {
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
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

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
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
}
