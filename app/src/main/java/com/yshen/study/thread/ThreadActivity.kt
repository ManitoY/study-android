package com.yshen.study.thread

import android.content.Intent
import com.yshen.study.R
import com.yshen.study.base.BaseActivity
import com.yshen.study.base.Constants
import com.yshen.study.thread.handler.HandlerActivity
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_thread

    override fun afterViews() {
        handlerBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra(Constants.TITLE, handlerBtn.text)
            intent.setClass(this, HandlerActivity::class.java)
            startActivity(intent)
        }
    }
}