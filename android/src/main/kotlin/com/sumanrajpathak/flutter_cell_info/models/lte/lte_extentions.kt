package com.airfore.cell_info.models.lte

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellLte


fun getLte(cell: CellLte, cellData: CellData): CellLTE {

    val cellLTE = CellLTE()
    cellLTE.type = "LTE"
    cellData.type = "LTE"

    cellLTE.bandwidth = cell.bandwidth
    cellData.bandwidth = cell.bandwidth

    cellLTE.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellLTE.bandLTE = BandLTE()
    cell.band?.let {
        cellLTE.bandLTE.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber

        it.number?.let {
            cellLTE.bandLTE.number = it
            cellData.bandNumber = it
        }
        cellLTE.bandLTE.downlinkEarfcn = it.downlinkEarfcn
        it.name?.let {
            cellLTE.bandLTE.name = it
            cellData.bandName = it
        }
    }

    cellLTE.network =
            Network()
    cell.network?.let {
        cellLTE.network.iso = it.iso
        cellData.iso = it.iso

        cellLTE.network.mcc = it.mcc
        cellData.mcc = it.mcc

        cellLTE.network.mnc = it.mnc
        cellData.mnc = it.mnc
    }

    cellLTE.signalLTE = SignalLTE()
    cell.signal.let {
        cell.signal.cqi?.let {
            cellLTE.signalLTE.cqi = it
            cellData.cqi = it
        }
        cell.signal.rsrpAsu?.let {
            cellLTE.signalLTE.rsrpAsu = it
            cellData.rsrpAsu = it
        }
        cell.signal.rssiAsu?.let {
            cellLTE.signalLTE.rssiAsu = it
            cellData.rssiAsu = it
        }
        cell.signal.snr?.let {
            cellLTE.signalLTE.snr = it
            cellData.snr = it
        }
        cell.signal.timingAdvance?.let {
            cellLTE.signalLTE.timingAdvance = it
            cellData.timingAdvance = it
        }
        cell.signal.dbm?.let {
            cellLTE.signalLTE.dbm = it
            cellData.dbm = it
        }
        cell.signal.rssi?.let {
            cellLTE.signalLTE.rssi = it
            cellData.rssi = it
        }
        cell.signal.rsrp?.let {
            cellLTE.signalLTE.rsrp = it
            cellData.rsrp = it
        }
        cell.signal.rsrq?.let {
            cellLTE.signalLTE.rsrq = it
            cellData.rsrq = it
        }
    }

    cellLTE.eci = cell.eci
    cellData.eci = cell.eci

    cellLTE.cid = cell.cid
    cellData.cid = cell.cid

    cellLTE.enb = cell.enb
    cellData.enb = cell.enb

    cellLTE.tac = cell.tac
    cellData.tac = cell.tac

    cellLTE.pci = cell.pci
    cellData.pci = cell.pci

    cellLTE.ecgi = cell.ecgi
    cellData.ecgi = cell.ecgi

    cellLTE.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellLTE
}

fun getLteFake(cell: CellLte? = null): CellLTE {

    val cellLTE = CellLTE()
    cellLTE.type = "LTE"

    cellLTE.bandwidth = 0
    cellLTE.connectionStatus = " cell.connectionStatus.toString()"

    cellLTE.bandLTE = BandLTE()
    cellLTE.bandLTE.channelNumber = 0
    cellLTE.bandLTE.number = 0
    cellLTE.bandLTE.name = ""
    cellLTE.bandLTE.downlinkEarfcn = 0


    cellLTE.network =
            Network()

    cellLTE.network.iso = ""
    cellLTE.network.mcc = "it.mcc"
    cellLTE.network.mnc = ""

    cellLTE.signalLTE = SignalLTE()
    cellLTE.signalLTE.cqi = 0
    cellLTE.signalLTE.rsrpAsu = 0
    cellLTE.signalLTE.rssiAsu = 0
    cellLTE.signalLTE.snr = 0.0
    cellLTE.signalLTE.timingAdvance = 0
    cellLTE.signalLTE.dbm = 0
    cellLTE.signalLTE.rssi = 0
    cellLTE.signalLTE.rsrp = 0.0


    cellLTE.eci = 0
    cellLTE.cid = 0
    cellLTE.enb = 0
    cellLTE.tac = 0
    cellLTE.pci = 0
    cellLTE.subscriptionId = 0

    return cellLTE
}