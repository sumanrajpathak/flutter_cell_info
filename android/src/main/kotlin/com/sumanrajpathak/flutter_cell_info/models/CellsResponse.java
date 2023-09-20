package com.airfore.cell_info.models;

import androidx.annotation.Keep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Keep
public class CellsResponse implements Serializable {

    private final long createdAt = new Date().getTime();
    private List<CellType> primaryCellList  = new ArrayList<>();
    private List<CellType> neighboringCellList  = new ArrayList<>();
    private List<CellData> cellDataList  = new ArrayList<>();


    public CellsResponse() {
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public List<CellType> getPrimaryCellList() {
        return primaryCellList;
    }

    public void setPrimaryCellList(List<CellType> primaryCellList) {
        this.primaryCellList = primaryCellList;
    }

    public List<CellType> getNeighboringCellList() {
        return neighboringCellList;
    }

    public void setNeighboringCellList(List<CellType> neighboringCellList) {
        this.neighboringCellList = neighboringCellList;
    }

    public List<CellData> getCellDataList() {
        return cellDataList;
    }

    public void setCellDataList(List<CellData> cellDataList) {
        this.cellDataList = cellDataList;
    }
}
