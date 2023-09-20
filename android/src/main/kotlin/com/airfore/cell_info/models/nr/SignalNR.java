package com.airfore.cell_info.models.nr;

import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Signal;

import java.io.Serializable;
@Keep
public class SignalNR extends Signal implements Serializable {

    private int csiRsrp;
    private int csiRsrq;
    private int csiSinr;
    private int ssRsrp;
    private int ssRsrq;
    private int ssSinr;
    private int csiRsrpAsu;
    private int ssRsrpAsu;


    public SignalNR() {
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
}
