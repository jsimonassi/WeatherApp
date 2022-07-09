package com.simonassi.weatherapp.ui.permissions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.simonassi.weatherapp.R
import com.simonassi.weatherapp.ui.main.MainActivity

class RequestPermissionsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_permissions)

        val btn = findViewById<Button>(R.id.request_btn)

        btn.setOnClickListener {
            requestPermissionsAndNavigate()
        }
    }

    private fun requestPermissionsAndNavigate() {
        if (ContextCompat.checkSelfPermission(
                this@RequestPermissionsActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@RequestPermissionsActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this@RequestPermissionsActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this@RequestPermissionsActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            }
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        startActivity(Intent(this@RequestPermissionsActivity, MainActivity::class.java))
    }
}