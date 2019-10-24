package com.yshen.study.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_animation_name)
        setContentView(R.layout.activity_animation)
    }
}