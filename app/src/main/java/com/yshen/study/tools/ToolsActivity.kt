package com.yshen.study.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class ToolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_tools_name)
        setContentView(R.layout.activity_tools)
    }
}