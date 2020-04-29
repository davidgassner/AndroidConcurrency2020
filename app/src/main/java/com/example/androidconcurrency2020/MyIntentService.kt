package com.example.androidconcurrency2020

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import java.net.URL
import java.nio.charset.Charset

private const val EXTRA_FILE_URL = "com.example.androidconcurrency2020.extra.FILE_URL"

private const val JOB_ACTION = "com.example.androidconcurrency2020.extra.JOB_ACTION"
private const val JOB_ID = 1001

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * helper methods.
 */
class MyIntentService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        if (intent.action == JOB_ACTION) {
            val url = URL(intent.getStringExtra(EXTRA_FILE_URL))
            val contents = url.readText(Charset.defaultCharset())
            Log.i(LOG_TAG, contents)
        }
    }

    companion object {
        @JvmStatic
        fun startAction(context: Context, fileUrl: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = JOB_ACTION
                putExtra(EXTRA_FILE_URL, fileUrl)
            }
            enqueueWork(context, MyIntentService::class.java, JOB_ID, intent)
        }
    }
}
