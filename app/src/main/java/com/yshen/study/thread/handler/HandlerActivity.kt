package com.yshen.study.thread.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.yshen.study.R

/**
 * Created by Yshen
 * On 2019-10-28
 */
class HandlerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Handler 机制"
        setContentView(R.layout.activity_handler)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.fragment).navigateUp()
}