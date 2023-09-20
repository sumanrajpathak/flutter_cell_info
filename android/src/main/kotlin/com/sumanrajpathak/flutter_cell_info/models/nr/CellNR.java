package com.airfore.cell_info.models.nr;


import androidx.annotation.Keep;

import com.airfore.cell_info.models.common.Cell;
import com.airfore.cell_info.models.lte.BandLTE;
import com.airfore.cell_info.models.lte.SignalLTE;

import java.io.Serializable;
@Keep
public class CellNR extends Cell implements Serializable {

    private Long nci;
    private Integer tac;
    private Integer pci;
    private BandNR bandNR;
    private SignalNR signalNR;


    public CellNR() {
    }

    public Long getNci() {
        return nci;
    }

    public void setNci(Long nci) {
        this.nci = nci;
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

    public BandNR getBandNR() {
        return bandNR;
    }

    public void setBandNR(BandNR bandNR) {
        this.bandNR = bandNR;
    }

    public SignalNR getSignalNR() {
        return signalNR;
    }

    public void setSignalNR(SignalNR signalNR) {
        this.signalNR = signalNR;
    }
}

