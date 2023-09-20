package com.airfore.cell_info.models.common;

import androidx.annotation.Keep;

import java.io.Serializable;
@Keep
public class Band implements Serializable {

    private int channelNumber;
    private int number;
    private String name;

    public Band() {
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
