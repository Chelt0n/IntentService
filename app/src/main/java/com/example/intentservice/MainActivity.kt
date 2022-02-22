package com.example.intentservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.intentservice.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =  ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.start.setOnClickListener {
        }
        binding.next.setOnClickListener {
            CustomToastIntentService.startToast(this,UUID.randomUUID().toString(), 3_000L)

        }
        binding.stop.setOnClickListener {
        }
    }
}