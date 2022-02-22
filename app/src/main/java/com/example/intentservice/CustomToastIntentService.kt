package com.example.intentservice

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread

private const val KEY_MESSAGE = "KEY_MESSAGE"
private const val KEY_TIME = "KEY_TIME"

class CustomToastIntentService : CustomIntentService() {

    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            showToast(it)
        }
    }

    private fun showToast(it: Intent) {
        val message: String = it.getStringExtra(KEY_MESSAGE) ?: ""
        val time: Long = it.getLongExtra(KEY_TIME, 0)
        Thread.sleep(time)
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
        Log.d("@@@", message)


    }

    companion object {
        fun startToast(context: Context, message: String, time: Long) {
            val intent = Intent(context, CustomToastIntentService::class.java)
            intent.putExtra(KEY_MESSAGE, message)
            intent.putExtra(KEY_TIME, time)
            context.startService(intent)
        }
    }
}