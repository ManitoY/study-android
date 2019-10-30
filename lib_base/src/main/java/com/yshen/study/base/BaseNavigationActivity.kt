package com.yshen.study.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * Created by Yshen
 * On 2019-10-29
 */
abstract class BaseNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        afterViews()
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(getFragmentId()).navigateUp()

    @LayoutRes abstract fun getLayoutId(): Int

    @IdRes abstract fun getFragmentId(): Int

    abstract fun afterViews()
}