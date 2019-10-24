package com.yshen.study.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class ComponentsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_components_name)
        setContentView(R.layout.activity_components)
    }
}