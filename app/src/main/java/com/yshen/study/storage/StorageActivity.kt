package com.yshen.study.storage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.R

class StorageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.main_storage_name)
        setContentView(R.layout.activity_storage)
    }
}