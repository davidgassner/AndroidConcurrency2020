package com.example.androidconcurrency2020

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters):
    Worker(context, params){
    override fun doWork(): Result {
        Log.i(LOG_TAG, "Doing some work!")
        return Result.success()
    }
}