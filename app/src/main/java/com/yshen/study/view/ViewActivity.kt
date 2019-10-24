package com.yshen.study.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_view_name)
        setContentView(R.layout.activity_view)
    }
}