package com.yshen.study.thread

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_thread_name)
        setContentView(R.layout.activity_thread)
    }
}