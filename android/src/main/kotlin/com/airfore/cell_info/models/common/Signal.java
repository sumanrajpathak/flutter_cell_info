package com.airfore.cell_info.models.common;

import androidx.annotation.Keep;

import java.io.Serializable;
@Keep
public class Signal implements Serializable {

    private int dbm;

    public Signal() {
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }
}
