package com.airfore.cell_info.models.gsm;

import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Band;

import java.io.Serializable;
@Keep
public class BandGSM extends Band implements Serializable {

    private int arfcn;

    public BandGSM() {
    }


    public int getArfcn() {
        return arfcn;
    }

    public void setArfcn(int arfcn) {
        this.arfcn = arfcn;
    }
}
