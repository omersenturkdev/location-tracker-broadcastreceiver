package com.omersenturk.locationtracker


import android.content.Intent
import android.content.IntentFilter
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val locationChangeReceiver = LocationChangeReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        checkLocationService()

    }

    override fun onResume() {
        super.onResume()
        registerReceiver(
            locationChangeReceiver,
            IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        )
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(locationChangeReceiver)
    }

    fun checkLocationService(){
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        val isLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (isLocationEnabled.not()){
            openLocationSettings()
        }
    }
    fun openLocationSettings(){
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivity(intent)
    }
}