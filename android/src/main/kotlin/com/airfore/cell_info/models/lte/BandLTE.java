package com.airfore.cell_info.models.lte;

import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Band;

import java.io.Serializable;
@Keep
public class BandLTE extends Band implements Serializable {

    private int downlinkEarfcn;

    public BandLTE() {
    }

    public int getDownlinkEarfcn() {
        return downlinkEarfcn;
    }

    public void setDownlinkEarfcn(int downlinkEarfcn) {
        this.downlinkEarfcn = downlinkEarfcn;
    }
}
