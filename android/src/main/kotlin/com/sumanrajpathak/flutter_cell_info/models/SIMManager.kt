package com.sumanrajpathak.flutter_cell_info.models

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.SubscriptionInfo
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import java.lang.reflect.Method

class SIMManager {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private fun manager(context: Context) {
        val subscriptionManager = context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
        }
    }

    fun getDataSimOperator(context: Context?): String? {
        if (context == null) {
            return null
        }
        val tm: TelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return if (tm != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val dataSubId = SubscriptionManager.getDefaultDataSubscriptionId()
                    val dataSimManager: TelephonyManager = tm.createForSubscriptionId(dataSubId)
                    dataSimManager.getSimOperator()
                } else {
                    val operator = getDataSimOperatorBeforeN(context)
                    operator ?: tm.getSimOperator()
                }
            } else {
                tm.getSimOperator()
            }
        } else null
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private fun getDataSimOperatorBeforeN(context: Context?): String? {
        if (context == null) {
            return null
        }
        var dataSubId = -1
        try {
            val getDefaultDataSubId: Method? = SubscriptionManager::class.java.getDeclaredMethod("getDefaultDataSubId")
            if (getDefaultDataSubId != null) {
                getDefaultDataSubId.setAccessible(true)
                dataSubId = getDefaultDataSubId.invoke(null) as Int
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (dataSubId != -1) {
            val sm = context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
            if (sm != null && ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                val si: SubscriptionInfo? = sm.getActiveSubscriptionInfo(dataSubId)
                if (si != null) {
                    // format keep the same with android.telephony.TelephonyManager#getSimOperator
                    // MCC + MNC format
                    return java.lang.String.valueOf(si.getMcc()) + si.getMnc()
                }
            }
        }
        return null
    }
}