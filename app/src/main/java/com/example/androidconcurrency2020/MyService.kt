package com.example.androidconcurrency2020

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val binder = MyServiceBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    fun doSomething() {
        Log.i(LOG_TAG, "The service is doing something!")
    }

    inner class MyServiceBinder : Binder() {
        fun getService() = this@MyService
    }
}
