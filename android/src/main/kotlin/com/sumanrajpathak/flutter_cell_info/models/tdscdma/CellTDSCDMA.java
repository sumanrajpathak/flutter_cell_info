package com.airfore.cell_info.models.tdscdma;


import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Cell;

import java.io.Serializable;
@Keep
public class CellTDSCDMA extends Cell implements Serializable {

    private Integer ci;
    private Integer lac;
    private Integer cpid;
    private Integer cid;
    private Integer rnc;
    private Integer cgi;
    private BandTDSCDMA bandTDSCDMA;
    private SignalTDSCDMA signalTDSCDMA;

    public CellTDSCDMA() {
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRnc() {
        return rnc;
    }

    public void setRnc(Integer rnc) {
        this.rnc = rnc;
    }

    public Integer getCgi() {
        return cgi;
    }

    public void setCgi(Integer cgi) {
        this.cgi = cgi;
    }

    public BandTDSCDMA getBandTDSCDMA() {
        return bandTDSCDMA;
    }

    public void setBandTDSCDMA(BandTDSCDMA bandTDSCDMA) {
        this.bandTDSCDMA = bandTDSCDMA;
    }

    public SignalTDSCDMA getSignalTDSCDMA() {
        return signalTDSCDMA;
    }

    public void setSignalTDSCDMA(SignalTDSCDMA signalTDSCDMA) {
        this.signalTDSCDMA = signalTDSCDMA;
    }
}

