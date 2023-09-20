package com.sumanrajpathak.cell_info_example

import android.Manifest
import android.util.Log
import androidx.core.app.ActivityCompat
import com.sumanrajpathak.flutter_cell_info.NetMonster
import io.flutter.embedding.android.FlutterActivity

class MainActivity : FlutterActivity() {
    override fun onStart() {
        super.onStart()

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            33
        )

    }

}
