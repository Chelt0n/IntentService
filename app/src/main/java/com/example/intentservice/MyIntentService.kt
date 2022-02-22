package com.example.intentservice

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.widget.Toast

private const val KEY_MESSAGE = "KEY_MESSAGE"
private const val KEY_TIME = "KEY_TIME"

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            showToast(it)
        }
    }

    private fun showToast(it: Intent) {
        val message: String = it.getStringExtra(KEY_MESSAGE) ?: ""
        val time: Long = it.getLongExtra(KEY_TIME, 0)
        Thread.sleep(time)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object{
        fun startToast(context: Context,message:String,time:Long){
            val intent = Intent(context,MyIntentService::class.java)
            intent.putExtra(KEY_MESSAGE,message)
            intent.putExtra(KEY_TIME,time)
            context.startService(intent)
        }
    }
}