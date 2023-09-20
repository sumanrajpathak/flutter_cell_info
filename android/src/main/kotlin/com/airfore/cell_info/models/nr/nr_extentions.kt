package com.airfore.cell_info.models.nr

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellNr

fun getNr(cell: CellNr, cellData: CellData): CellNR {

    val cellNR = CellNR()
    cellNR.type = "NR"
    cellData.type = "NR"

    cellNR.nci = cell.nci
    cellData.nci = cell.nci

    cellNR.pci = cell.pci
    cellData.pci = cell.pci

    cellNR.tac = cell.tac
    cellData.tac = cell.tac

    cellNR.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellNR.bandNR = BandNR()
    cell.band?.let {
        cellNR.bandNR.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber

        cellNR.bandNR.number = it.number!!
        cellData.bandNumber = it.number

        cellNR.bandNR.downlinkArfcn = it.downlinkArfcn
        cellData.bandDownlinkArfcn = it.downlinkArfcn

        cellNR.bandNR.downlinkFrequency = it.downlinkFrequency
        cellData.bandDownlinkFrequency = it.downlinkFrequency

        cellNR.bandNR.name = it.name!!
        cellData.bandName = it.name
    }

    cellNR.network =
            Network()
    cell.network?.let {
        cellNR.network.iso = it.iso
        cellData.iso = it.iso

        cellNR.network.mcc = it.mcc
        cellData.mcc = it.mcc

        cellNR.network.mnc = it.mnc
        cellData.mnc = it.mnc
    }

    cellNR.signalNR = SignalNR()
    cell.signal.let {
        cellNR.signalNR.csiRsrp = cell.signal.csiRsrp!!
        cellData.csiRsrp = cell.signal.csiRsrp

        cellNR.signalNR.csiRsrpAsu = cell.signal.csiRsrpAsu!!
        cellData.csiRsrpAsu = cell.signal.csiRsrpAsu!!

        cellNR.signalNR.csiRsrq = cell.signal.csiRsrq!!
        cellData.csiRsrq = cell.signal.csiRsrq

        cellNR.signalNR.csiSinr = cell.signal.csiSinr!!
        cellData.csiSinr = cell.signal.csiSinr

        cellNR.signalNR.ssRsrq = cell.signal.ssRsrp!!
        cellData.ssRsrq = cell.signal.ssRsrp

        cellNR.signalNR.dbm = cell.signal.dbm!!
        cellData.dbm = cell.signal.dbm!!

        cellNR.signalNR.ssRsrp = cell.signal.ssRsrp
        cellData.ssRsrp = cell.signal.ssRsrp

        cellNR.signalNR.ssRsrpAsu = cell.signal.ssRsrpAsu!!
        cellData.ssRsrpAsu = cell.signal.ssRsrpAsu!!

    }


    cellNR.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellNR
}

fun getNrFake(cell: CellNr? = null): CellNR {

    val cellNR = CellNR()
    cellNR.type = "NR"

    cellNR.nci = 0
    cellNR.pci = 0
    cellNR.tac = 0
    cellNR.connectionStatus = " cell.connectionStatus.toString()"

    cellNR.bandNR = BandNR()

    cellNR.bandNR.channelNumber = 0
    cellNR.bandNR.number = 0
    cellNR.bandNR.downlinkArfcn = 0
    cellNR.bandNR.downlinkFrequency = 0
    cellNR.bandNR.name = "it.name!!"

    cellNR.network =
            Network()
    cellNR.network.iso = "0"
    cellNR.network.mcc = "0"
    cellNR.network.mnc = "0"

    cellNR.signalNR = SignalNR()
    cellNR.signalNR.csiRsrp = 0
    cellNR.signalNR.csiRsrpAsu = 0
    cellNR.signalNR.csiRsrq = 0
    cellNR.signalNR.csiSinr = 0
    cellNR.signalNR.ssRsrq = 0
    cellNR.signalNR.dbm = 0
    cellNR.signalNR.ssRsrp = 0
    cellNR.signalNR.ssRsrpAsu = 0

    return cellNR
}
