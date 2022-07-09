package com.simonassi.weatherapp.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.simonassi.weatherapp.R
import com.simonassi.weatherapp.ui.main.MainActivity
import com.simonassi.weatherapp.ui.permissions.RequestPermissionsActivity
import java.util.*
import kotlin.concurrent.schedule


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash);

        var intent = Intent(this@SplashActivity, RequestPermissionsActivity::class.java)
        if(hasPermissions()) intent = Intent(this@SplashActivity, MainActivity::class.java)

        Timer().schedule(2000) {
            startActivity(intent)
            finish()
        }
    }

    private fun hasPermissions(): Boolean {
        val permission = ContextCompat
            .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)

        return permission == PackageManager.PERMISSION_GRANTED
    }
}