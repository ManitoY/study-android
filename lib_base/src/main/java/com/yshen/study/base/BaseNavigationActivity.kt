package com.yshen.study.base

import androidx.annotation.IdRes
import androidx.navigation.findNavController

/**
 * Created by Yshen
 * On 2019-10-29
 */
abstract class BaseNavigationActivity : BaseActivity() {

    override fun onSupportNavigateUp(): Boolean = findNavController(getFragmentId()).navigateUp()

    @IdRes abstract fun getFragmentId(): Int
}