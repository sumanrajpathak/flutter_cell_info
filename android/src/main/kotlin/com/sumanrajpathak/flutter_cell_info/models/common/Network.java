package com.airfore.cell_info.models.common;

import androidx.annotation.Keep;

import java.io.Serializable;
@Keep
public class Network implements Serializable {
    private String mcc;
    private String mnc;
    private String iso;

    public Network() {
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
}
