package com.airfore.cell_info.models.lte;


import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Cell;

import java.io.Serializable;
@Keep
public class CellLTE extends Cell implements Serializable {

    private Integer bandwidth;
    private Integer eci;
    private Integer tac;
    private Integer pci;
    private Integer enb;
    private Integer cid;
    private String ecgi;
    private BandLTE bandLTE;
    private SignalLTE signalLTE;


    public CellLTE() {
    }

    public SignalLTE getSignal() {
        return signalLTE;
    }

    public SignalLTE getSignalLTE() {
        return signalLTE;
    }

    public void setSignalLTE(SignalLTE signalLTE) {
        this.signalLTE = signalLTE;
    }

    public void setSignal(SignalLTE signal) {
        this.signalLTE = signal;
    }

    public BandLTE getBandLTE() {
        return bandLTE;
    }

    public void setBandLTE(BandLTE bandLTE) {
        this.bandLTE = bandLTE;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public Integer getEnb() {
        return enb;
    }

    public void setEnb(Integer enb) {
        this.enb = enb;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getEcgi() {
        return ecgi;
    }

    public void setEcgi(String ecgi) {
        this.ecgi = ecgi;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getEci() {
        return eci;
    }

    public void setEci(Integer eci) {
        this.eci = eci;
    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public Integer getPci() {
        return pci;
    }

    public void setPci(Integer pci) {
        this.pci = pci;
    }
}

