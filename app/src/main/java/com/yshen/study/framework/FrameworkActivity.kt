package com.yshen.study.framework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class FrameworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_framework_name)
        setContentView(R.layout.activity_framework)
    }
}