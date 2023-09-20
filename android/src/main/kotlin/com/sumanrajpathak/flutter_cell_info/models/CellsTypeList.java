package com.sumanrajpathak.flutter_cell_info.models;

import androidx.annotation.Keep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Keep
public class CellsTypeList implements Serializable {

    private List<CellType> primaryCellList = new ArrayList<>();

    public CellsTypeList() {
    }

    public List<CellType> getPrimaryCellList() {
        return primaryCellList;
    }

    public void setPrimaryCellList(List<CellType> primaryCellList) {
        this.primaryCellList = primaryCellList;
    }
}
