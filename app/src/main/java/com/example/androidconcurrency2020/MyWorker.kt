package com.example.androidconcurrency2020

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MyWorker(context: Context, params: WorkerParameters):
    CoroutineWorker(context, params){
    override suspend fun doWork(): Result {

        val data = withContext(Dispatchers.IO) {
            setProgress(workDataOf(MESSAGE_KEY to "Doing some work"))
            delay(1000)
            setProgress(workDataOf(MESSAGE_KEY to "Doing some more work"))
            delay(1000)
            setProgress(workDataOf(MESSAGE_KEY to "Almost done"))
            delay(1000)
            val url = URL(FILE_URL)
            return@withContext url.readText(Charset.defaultCharset())
        }

        val result = workDataOf(DATA_KEY to data)
        return Result.success(result)
    }
}