package com.yshen.study.designmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class DesignModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_design_model_name)
        setContentView(R.layout.activity_design_model)
    }
}