package com.yshen.study.network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_network_name)
        setContentView(R.layout.activity_network)
    }
}