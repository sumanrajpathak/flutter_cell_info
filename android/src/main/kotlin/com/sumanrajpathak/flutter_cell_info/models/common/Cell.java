package com.airfore.cell_info.models.common;

import android.Manifest;

import androidx.annotation.Keep;
import androidx.core.app.ActivityCompat;

import java.io.Serializable;
@Keep
public class Cell implements Serializable {

    private Integer subscriptionId;
    private String connectionStatus;
    private String type;
    private Network network;

    public Cell() {
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


    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

}
