package com.example.abc

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App:Application() {
    final public val CHANNEL_ID1="CHANNEL_ID1"
    final public val CHANNEL_ID2="CHANNEL_ID2"
    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channerl1 = NotificationChannel(CHANNEL_ID1,
                "Channel 1", NotificationManager.IMPORTANCE_HIGH)
            channerl1.description = "This my high important channel for notification"

            val channerl2 = NotificationChannel(CHANNEL_ID2,
                "Channel 2", NotificationManager.IMPORTANCE_HIGH)
            channerl2.description = "This my high important channel for notification"

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(channerl1)
            manager.createNotificationChannel(channerl2)
        }
    }
}