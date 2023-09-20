package com.sumanrajpathak.flutter_cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.SubscriptionManager
import androidx.annotation.RequiresApi
import com.sumanrajpathak.flutter_cell_info.models.*
import com.sumanrajpathak.flutter_cell_info.models.cdma.getCdma
import com.sumanrajpathak.flutter_cell_info.models.gsm.getGsm
import com.sumanrajpathak.flutter_cell_info.models.lte.getLte
import com.sumanrajpathak.flutter_cell_info.models.nr.getNr
import com.sumanrajpathak.flutter_cell_info.models.tdscdma.getTdscdma
import com.sumanrajpathak.flutter_cell_info.models.wcdma.getWcdma
import com.google.gson.Gson
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection
import java.util.*
import kotlin.collections.ArrayList


class NetMonster {

    private val TAG = "NetMonster"

    private val primaryCellList: MutableList<CellType> = ArrayList()
    private val neighboringCellList: MutableList<CellType> = ArrayList()
    private val cellDataList: MutableList<CellData> = ArrayList()

    @SuppressLint("MissingPermission")
    fun requestData(
        context: Context,
        result: io.flutter.plugin.common.MethodChannel.Result? = null
    ): CellsResponse {
        NetMonsterFactory.get(context).apply {
            val merged = getCells()
            merged.forEach { cell ->
                val cellData = CellData()
                cellData.timestamp = Date().time
                when (cell) {

                    is CellNr -> {

                        val cellType = CellType()
                        cellType.nr = getNr(cell, cellData)
                        cellType.type = "NR"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                                cellDataList.add(cellData)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }


                    }
                    is CellLte -> {

                        val cellType = CellType()


                        cellType.lte = getLte(cell, cellData)
                        cellType.type = "LTE"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                                cellDataList.add(cellData)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }

                    }
                    is CellWcdma -> {

                        val cellType = CellType()


                        cellType.wcdma = getWcdma(cell, cellData)
                        cellType.type = "WCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                                cellDataList.add(cellData)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }


                    }
                    is CellCdma -> {

                        val cellType = CellType()


                        cellType.cdma = getCdma(cell, cellData)
                        cellType.type = "WCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                                cellDataList.add(cellData)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }


                    }
                    is CellGsm -> {


                        val cellType = CellType()


                        cellType.gsm = getGsm(cell, cellData)
                        cellType.type = "GSM"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                                cellDataList.add(cellData)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }

                    }
                    is CellTdscdma -> {

                        val cellType = CellType()

                        cellType.tdscdma = getTdscdma(cell, cellData)
                        cellType.type = "TDSCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                primaryCellList.add(cellType)
                                cellDataList.add(cellData)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }

                    }

                    else -> {
                    }

                }
            }
        }

        val cellsResponse = CellsResponse()
        cellsResponse.neighboringCellList = neighboringCellList
        cellsResponse.primaryCellList = primaryCellList
        cellsResponse.cellDataList = cellDataList
        if (result != null) {
            val json = Gson().toJson(cellsResponse)
            result.success(json)
        }
        return cellsResponse
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun simsInfo(
        context: Context,
        result: io.flutter.plugin.common.MethodChannel.Result? = null
    ): ArrayList<SIMInfo> {

        val simInfoLists = ArrayList<SIMInfo>()
        val subscriptionManager =
            context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
        val activeSubscriptionInfoList = subscriptionManager.activeSubscriptionInfoList
        for (subscriptionInfo in activeSubscriptionInfoList) {
            val carrierName = subscriptionInfo.carrierName
            val displayName = subscriptionInfo.displayName
            val mcc = subscriptionInfo.mcc
            val mnc = subscriptionInfo.mnc
            val subscriptionInfoNumber = subscriptionInfo.number
            simInfoLists.add(
                SIMInfo(
                    carrierName.toString(),
                    displayName.toString(),
                    mcc,
                    mnc,
                    subscriptionInfoNumber
                )
            )
        }

        val json = Gson().toJson(SIMInfoResponse(simInfoLists))
        result?.success(json)
        return simInfoLists
    }
}


// region fake data
//
//        val wcdmaCellType = CellType()
//        wcdmaCellType.wcdma = getWcdmaFake()
//        wcdmaCellType.type = "WCDMA"
//        cellsResponse.neighboringCellList.add(wcdmaCellType)
//        cellsResponse.primaryCellList.add(wcdmaCellType)
//
//        val nrCellType = CellType()
//        nrCellType.nr = getNrFake()
//        nrCellType.type = "NR"
//        cellsResponse.neighboringCellList.add(nrCellType)
//        cellsResponse.primaryCellList.add(nrCellType)
//
//        val LTECellType = CellType()
//        LTECellType.lte = getLteFake()
//        LTECellType.type = "LTE"
//        cellsResponse.neighboringCellList.add(LTECellType)
//        cellsResponse.primaryCellList.add(LTECellType)
//
//
//        val gsmType = CellType()
//        gsmType.gsm = getGsmFake()
//        gsmType.type = "GSM"
//        cellsResponse.neighboringCellList.add(gsmType)
//        cellsResponse.primaryCellList.add(gsmType)
//
//        val tdscdmaCellType = CellType()
//        tdscdmaCellType.tdscdma = getTdscdmaFake()
//        tdscdmaCellType.type = "tdscdma"
//        cellsResponse.neighboringCellList.add(tdscdmaCellType)
//        cellsResponse.primaryCellList.add(tdscdmaCellType)
//
//
//        val cdmaCellType = CellType()
//        cdmaCellType.cdma = getCdmaFake()
//        cdmaCellType.type = "CDMA"
//        cellsResponse.neighboringCellList.add(cdmaCellType)
//        cellsResponse.primaryCellList.add(cdmaCellType)
//endregion
