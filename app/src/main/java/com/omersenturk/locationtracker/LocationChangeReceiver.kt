package com.omersenturk.locationtracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager

class LocationChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == LocationManager.PROVIDERS_CHANGED_ACTION)
        {
            if (context is MainActivity)
            {
                context.checkLocationService()
            }
        }
    }
}