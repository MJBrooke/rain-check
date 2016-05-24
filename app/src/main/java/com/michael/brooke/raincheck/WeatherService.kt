package com.michael.brooke.raincheck

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class WeatherService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val activityIntent = Intent(baseContext, EmptyActivity::class.java)
        activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(activityIntent)
        toast("WeatherService Started")
        return 1
    }

    override fun onDestroy() {
        toast("WeatherService Stopped")
    }

    fun toast(str: String) = Toast.makeText(this, str, Toast.LENGTH_LONG).show()
}
