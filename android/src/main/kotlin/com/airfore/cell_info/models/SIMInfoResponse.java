package com.airfore.cell_info.models;

import androidx.annotation.Keep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Keep
public class SIMInfoResponse implements Serializable {

    private List<SIMInfo> simInfoList = new ArrayList<>();

    public SIMInfoResponse() {
    }

    public SIMInfoResponse(List<SIMInfo> simInfoList) {
        this.simInfoList = simInfoList;
    }

    public List<SIMInfo> getSimInfoList() {
        return simInfoList;
    }

    public void setSimInfoList(List<SIMInfo> simInfoList) {
        this.simInfoList = simInfoList;
    }
}
