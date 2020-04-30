package com.example.androidconcurrency2020

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.net.URL
import java.nio.charset.Charset

class MyWorker(context: Context, params: WorkerParameters):
    Worker(context, params){
    override fun doWork(): Result {
        Log.i(LOG_TAG, "Doing some work!")
        val url = URL(FILE_URL)
        val data = url.readText(Charset.defaultCharset())
        val result = workDataOf(DATA_KEY to data)
        return Result.success(result)
    }
}