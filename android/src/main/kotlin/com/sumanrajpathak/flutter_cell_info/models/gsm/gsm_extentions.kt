package com.sumanrajpathak.flutter_cell_info.models.gsm

import com.sumanrajpathak.flutter_cell_info.models.CellData
import com.sumanrajpathak.flutter_cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellGsm

fun getGsm(cell: CellGsm, cellData: CellData): CellGSM {

    val cellGSM = CellGSM()
    cellGSM.type = "GSM"
    cellData.type = "GSM"

    cellGSM.bandGSM = BandGSM()
    cellGSM.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()
    cellGSM.lac = cell.lac
    cellGSM.cid = cell.cid
    cellGSM.bsic = cell.bsic
    cellGSM.ncc = cell.ncc
    cellGSM.bcc = cell.bcc
    cellGSM.cgi = cell.cgi
    cellGSM.bandGSM = BandGSM()
    cell.band?.let {
        cellGSM.bandGSM.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber
        it.number?.let {
            cellGSM.bandGSM.number = it
            cellData.bandNumber = it
        }
        it.name?.let {
            cellGSM.bandGSM.name = it
            cellData.bandName = it
        }
        cellGSM.bandGSM.arfcn = it.arfcn
        cellData.arfcn = it.arfcn
    }

    cellGSM.network =
        Network()
    cell.network?.let {
        cellGSM.network.iso = it.iso
        cellGSM.network.mcc = it.mcc
        cellGSM.network.mnc = it.mnc
    }

    cellGSM.signalGSM = SignalGSM()
    cell.signal.let {
        cell.signal.bitErrorRate?.let {
            cellGSM.signalGSM.bitErrorRate = it
        }
        cell.signal.rssi?.let {
            cellGSM.signalGSM.rssi = it
        }
        cell.signal.timingAdvance?.let {
            cellGSM.signalGSM.timingAdvance = it
        }
        cell.signal.dbm?.let {
            cellGSM.signalGSM.dbm = it
        }
    }

    cellGSM.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellGSM
}

fun getGsmFake(cell: CellGsm? = null): CellGSM {

    val cellGSM = CellGSM()
    cellGSM.type = "GSM"

    cellGSM.bandGSM = BandGSM()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandGSM = BandGSM()
    cellGSM.bandGSM.channelNumber = 2
    cellGSM.bandGSM.number = 0
    cellGSM.bandGSM.name = ""
    cellGSM.bandGSM.arfcn = 0


    cellGSM.network =
        Network()
    cellGSM.network.iso = ""
    cellGSM.network.mcc = ""
    cellGSM.network.mnc = ""

    cellGSM.signalGSM = SignalGSM()

    cellGSM.signalGSM.bitErrorRate = 0
    cellGSM.signalGSM.rssi = 0
    cellGSM.signalGSM.timingAdvance = 0
    cellGSM.signalGSM.dbm = 0

    return cellGSM
}