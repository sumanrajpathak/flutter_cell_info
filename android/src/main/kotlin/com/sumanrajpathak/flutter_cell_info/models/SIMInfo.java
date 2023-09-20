package com.airfore.cell_info.models;

import androidx.annotation.Keep;

import java.io.Serializable;
@Keep
public class SIMInfo implements Serializable {

    private String carrierName;
    private String displayName;
    private int mcc;
    private int mnc;
    private String subscriptionInfoNumber;

    public SIMInfo(String carrierName, String displayName, int mcc, int mnc, String subscriptionInfoNumber) {
        this.carrierName = carrierName;
        this.displayName = displayName;
        this.mcc = mcc;
        this.mnc = mnc;
        this.subscriptionInfoNumber = subscriptionInfoNumber;
    }

    public SIMInfo() {
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public int getMnc() {
        return mnc;
    }

    public void setMnc(int mnc) {
        this.mnc = mnc;
    }

    public String getSubscriptionInfoNumber() {
        return subscriptionInfoNumber;
    }

    public void setSubscriptionInfoNumber(String subscriptionInfoNumber) {
        this.subscriptionInfoNumber = subscriptionInfoNumber;
    }

    @Override
    public String toString() {
        return "SIMInfo{" +
                "carrierName='" + carrierName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", mcc=" + mcc +
                ", mnc=" + mnc +
                ", subscriptionInfoNumber='" + subscriptionInfoNumber + '\'' +
                '}';
    }
}
