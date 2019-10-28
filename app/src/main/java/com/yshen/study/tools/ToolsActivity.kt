package com.yshen.study.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

/**
 * Created by Yshen
 * On 2019-10-24
 */
class ToolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_tools_name)
        setContentView(R.layout.activity_tools)
    }
}