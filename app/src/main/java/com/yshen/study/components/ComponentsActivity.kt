package com.yshen.study.components

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R
import com.yshen.study.components.activity.ActivityActivity
import kotlinx.android.synthetic.main.activity_components.*

class ComponentsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_components_name)
        setContentView(R.layout.activity_components)
        activityBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ActivityActivity::class.java)
            startActivity(intent)
        }
    }
}