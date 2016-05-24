package com.michael.brooke.raincheck

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/*
Receives the BroadCast that the device has finished booting, and that the weather service can be started
 */
class WeatherReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val startIntent = Intent(context, WeatherService::class.java)
        context.startService(startIntent)
    }
}
