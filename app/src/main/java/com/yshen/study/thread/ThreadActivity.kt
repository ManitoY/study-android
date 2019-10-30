package com.yshen.study.thread

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R
import com.yshen.study.thread.handler.HandlerActivity
import kotlinx.android.synthetic.main.activity_thread.*

/**
 * Created by Yshen
 * On 2019-10-24
 */
class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_thread_name)
        setContentView(R.layout.activity_thread)
        handlerBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, HandlerActivity::class.java)
            startActivity(intent)
        }
    }
}