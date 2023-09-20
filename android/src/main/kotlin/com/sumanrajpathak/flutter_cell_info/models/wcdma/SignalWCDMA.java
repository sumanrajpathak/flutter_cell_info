package com.airfore.cell_info.models.wcdma;

import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Signal;

import java.io.Serializable;
@Keep
public class SignalWCDMA extends Signal implements Serializable {

    private int rssi;
    private int bitErrorRate;
    private int rscp;
    private int rscpAsu;
    private int rssiAsu;
    private int ecno;
    private int ecio;


    public SignalWCDMA() {
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

    public int getRssiAsu() {
        return rssiAsu;
    }

    public void setRssiAsu(int rssiAsu) {
        this.rssiAsu = rssiAsu;
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
}
