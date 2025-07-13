package com.omersenturk.locationtracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager

class LocationChangeReceiver(private val onLocationDisabled: () -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (intent?.action != LocationManager.PROVIDERS_CHANGED_ACTION) return

        if (isLocationEnabled.not()) {
            onLocationDisabled()
        }
    }
}