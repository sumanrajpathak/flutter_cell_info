package com.airfore.cell_info.models.wcdma

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.band.BandWcdma
import cz.mroczis.netmonster.core.model.cell.CellWcdma
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection
import cz.mroczis.netmonster.core.model.signal.SignalWcdma

fun getWcdma(cell: CellWcdma, cellData: CellData): CellWCDMA {

    val cellGSM = CellWCDMA()
    cellGSM.type = "WCDMA"
    cellData.type = "WCDMA"

    cellGSM.bandWCDMA = BandWCDMA()
    cellGSM.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellGSM.ci = cell.ci
    cellGSM.lac = cell.lac
    cellGSM.psc = cell.psc
    cellGSM.cid = cell.cid
    cellGSM.rnc = cell.rnc
    cellGSM.cgi = cell.cgi


    cellGSM.bandWCDMA = BandWCDMA()
    cell.band?.let {
        cellGSM.bandWCDMA.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber
        it.number?.let {
            cellGSM.bandWCDMA.number = it
            cellData.bandNumber = it
        }
        it.name?.let {
            cellGSM.bandWCDMA.name = it
            cellData.bandName = it
        }
        cellGSM.bandWCDMA.downlinkUarfcn = it.downlinkUarfcn
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

    cellGSM.signalWCDMA = SignalWCDMA()
    cell.signal.let {
        cell.signal.bitErrorRate?.let {
            cellGSM.signalWCDMA.bitErrorRate = it
            cellData.bitErrorRate = it
        }
        cell.signal.rssi?.let {
            cellGSM.signalWCDMA.rssi = it
            cellData.rssi = it
        }
        cell.signal.rscp?.let {
            cellGSM.signalWCDMA.rscp = it
            cellData.rscp = it
        }
        cell.signal.rscpAsu?.let {
            cellGSM.signalWCDMA.rscpAsu = it
            cellData.rscpAsu = it
        }
        cell.signal.rssiAsu?.let {
            cellGSM.signalWCDMA.rssiAsu = it
            cellData.rssiAsu = it
        }
        cell.signal.ecno?.let {
            cellGSM.signalWCDMA.ecno = it
            cellData.ecno = it
        }
        cell.signal.ecio?.let {
            cellGSM.signalWCDMA.ecio = it
            cellData.ecio = it
        }
        cell.signal.dbm?.let {
            cellGSM.signalWCDMA.dbm = it
            cellData.dbm = it
        }
    }

    cellGSM.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellGSM
}


fun getWcdmaFake(
    cell: CellWcdma = CellWcdma(
        network = cz.mroczis.netmonster.core.model.Network(
            "",
            "",
            ""
        ),
        band = BandWcdma(
            downlinkUarfcn = 0,
            name = "",
            number = 0
        ),
        ci = 0,
        connectionStatus = PrimaryConnection(),
        lac = 0,
        psc = 0,
        signal = SignalWcdma(
            rssi = -100,
            bitErrorRate = 0,
            ecio = 0, ecno = 0, rscp = -100

        ),
        subscriptionId = 0
    )
): CellWCDMA {

    val cellGSM = CellWCDMA()
    cellGSM.type = "WCDMA"

    cellGSM.bandWCDMA = BandWCDMA()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandWCDMA = BandWCDMA()
    cell.band?.let {
        cellGSM.bandWCDMA.channelNumber = 0
        it.number?.let {
            cellGSM.bandWCDMA.number = 0
        }
        it.name?.let {
            cellGSM.bandWCDMA.name = "0"
        }
        cellGSM.bandWCDMA.downlinkUarfcn = 0
    }

    cellGSM.network =
        Network()
    cell.network?.let {
        cellGSM.network.iso = "it.iso"
        cellGSM.network.mcc = "it.mcc"
        cellGSM.network.mnc = "it.mnc"
    }

    cellGSM.signalWCDMA = SignalWCDMA()
    cell.signal.let {
        cell.signal.bitErrorRate?.let {
            cellGSM.signalWCDMA.bitErrorRate = 0
        }
        cell.signal.rssi?.let {
            cellGSM.signalWCDMA.rssi = 0
        }
        cell.signal.rscp?.let {
            cellGSM.signalWCDMA.rscp = 0
        }
        cell.signal.rscpAsu?.let {
            cellGSM.signalWCDMA.rscpAsu = 0
        }
        cell.signal.rssiAsu?.let {
            cellGSM.signalWCDMA.rssiAsu = 0
        }
        cell.signal.ecno?.let {
            cellGSM.signalWCDMA.ecno = 0
        }
        cell.signal.ecio?.let {
            cellGSM.signalWCDMA.ecio = 0
        }
        cell.signal.dbm?.let {
            cellGSM.signalWCDMA.dbm = 0
        }
    }

    return cellGSM
}