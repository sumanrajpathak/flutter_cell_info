package com.airfore.cell_info.models.nr;

import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Band;

import java.io.Serializable;
@Keep
public class BandNR extends Band implements Serializable {

    private int downlinkArfcn;
    private int downlinkFrequency;

    public BandNR() {
    }

    public int getDownlinkArfcn() {
        return downlinkArfcn;
    }

    public void setDownlinkArfcn(int downlinkArfcn) {
        this.downlinkArfcn = downlinkArfcn;
    }

    public int getDownlinkFrequency() {
        return downlinkFrequency;
    }

    public void setDownlinkFrequency(int downlinkFrequency) {
        this.downlinkFrequency = downlinkFrequency;
    }
}
