package com.airfore.cell_info.models.tdscdma

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellTdscdma

fun getTdscdma(cell: CellTdscdma, cellData: CellData): CellTDSCDMA {

    val cellGSM = CellTDSCDMA()
    cellGSM.type = "TDSCDMA"
    cellData.type = "TDSCDMA"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cell.band?.let {
        cellGSM.bandTDSCDMA.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber

        cellGSM.bandTDSCDMA.number = it.number!!
        cellData.bandNumber = it.number

        cellGSM.bandTDSCDMA.name = it.name!!
        cellData.bandName = it.name!!

        cellGSM.bandTDSCDMA.downlinkUarfcn = it.downlinkUarfcn
        cellData.downlinkUarfcn = it.downlinkUarfcn
    }

    cellGSM.network =
            Network()
    cell.network?.let {
        cellGSM.network.iso = it.iso
        cellData.iso = it.iso
        cellGSM.network.mcc = it.mcc
        cellData.mcc = it.mcc
        cellGSM.network.mnc = it.mnc
        cellData.mnc = it.mnc
    }

    cellGSM.signalTDSCDMA = SignalTDSCDMA()
    cell.signal.let {
        cellGSM.signalTDSCDMA.bitErrorRate = cell.signal.bitErrorRate!!
        cellData.bitErrorRate = cell.signal.bitErrorRate!!
        cellGSM.signalTDSCDMA.rssi = cell.signal.rssi!!
        cellData.rssi = cell.signal.rssi!!
        cellGSM.signalTDSCDMA.rscp = cell.signal.rscp!!
        cellData.rscp = cell.signal.rscp!!
        cellGSM.signalTDSCDMA.rscpAsu = cell.signal.rscpAsu!!
        cellData.rscpAsu = cell.signal.rscpAsu!!
        cellGSM.signalTDSCDMA.rssiAsu = cell.signal.rssiAsu!!
        cellData.rssiAsu = cell.signal.rssiAsu!!
        cellGSM.signalTDSCDMA.dbm = cell.signal.dbm!!
        cellData.dbm = cell.signal.dbm!!
    }


    cellGSM.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId


    return cellGSM
}

fun getTdscdmaFake(cell: CellTdscdma? = null): CellTDSCDMA {

    val cellGSM = CellTDSCDMA()
    cellGSM.type = "TDSCDMA"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.bandTDSCDMA.channelNumber = 0
    cellGSM.bandTDSCDMA.number = 0
    cellGSM.bandTDSCDMA.name = " it.name!!"
    cellGSM.bandTDSCDMA.downlinkUarfcn = 0

    cellGSM.network =
            Network()
    cellGSM.network.iso = ""
    cellGSM.network.mcc = ""
    cellGSM.network.mnc = ""

    cellGSM.signalTDSCDMA = SignalTDSCDMA()
    cellGSM.signalTDSCDMA.bitErrorRate = 0
    cellGSM.signalTDSCDMA.rssi = 0
    cellGSM.signalTDSCDMA.rscp = 0
    cellGSM.signalTDSCDMA.rscpAsu = 0
    cellGSM.signalTDSCDMA.rssiAsu = 0
    cellGSM.signalTDSCDMA.dbm = 0

    return cellGSM
}
