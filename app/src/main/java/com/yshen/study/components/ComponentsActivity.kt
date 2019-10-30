package com.yshen.study.components

import android.content.Intent
import com.yshen.study.R
import com.yshen.study.base.BaseActivity
import com.yshen.study.base.Constants
import com.yshen.study.components.activity.ActivityActivity
import kotlinx.android.synthetic.main.activity_components.*

class ComponentsActivity: BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_components

    override fun afterViews() {
        this.title = title
        activityBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra(Constants.TITLE, activityBtn.text)
            intent.setClass(this, ActivityActivity::class.java)
            startActivity(intent)
        }
    }
}