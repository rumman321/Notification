package com.example.abc

import android.app.Notification
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.abc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.High.setOnClickListener {
        val notification=Notification.Builder(this,App().CHANNEL_ID1)
            notification.setContentTitle(binding.Title.text.toString())
            notification.setContentTitle(binding.Content.text.toString())
            notification.setSmallIcon(R.drawable.high)
                notification.setPriority(Notification.PRIORITY_HIGH)
                .build()
            val manager=getSystemService(NOTIFICATION_SERVICE)as NotificationManager
            manager.notify(1,notification.build())
        }
        binding.Low.setOnClickListener {
            val notification=Notification.Builder(this,App().CHANNEL_ID2)
            notification.setContentTitle(binding.Title.text.toString())
            notification.setContentTitle(binding.Content.text.toString())
            notification.setPriority(Notification.PRIORITY_LOW)
            notification.setSmallIcon(R.drawable.low)
                .build()
            val manager=getSystemService(NOTIFICATION_SERVICE)as NotificationManager
            manager.notify(2,notification.build())
        }
    }
}