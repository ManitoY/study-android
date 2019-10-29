package com.yshen.study.components.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.yshen.study.R

/**
 * Created by Yshen
 * On 2019-10-29
 */
class ActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.fragment).navigateUp()
}