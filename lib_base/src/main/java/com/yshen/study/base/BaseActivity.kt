package com.yshen.study.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Yshen
 * On 2019-10-30
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        afterViews(intent.getStringExtra(Constants.TITLE))
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun afterViews(title: String?)
}