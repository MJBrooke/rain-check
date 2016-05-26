package com.michael.brooke.raincheck.broadcast.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.app.NotificationCompat
import com.michael.brooke.raincheck.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val notification = NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.notification_template_icon_bg)
            .setContentTitle("Rain Check")
            .setContentText("Now go implement the weather check!")
            .build()


        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notification)

    }
}
