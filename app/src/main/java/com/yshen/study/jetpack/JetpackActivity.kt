package com.yshen.study.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class JetPackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_jet_pack_name)
        setContentView(R.layout.activity_jetpack)
    }
}