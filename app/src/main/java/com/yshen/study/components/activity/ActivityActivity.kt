package com.yshen.study.components.activity

import com.yshen.study.R
import com.yshen.study.base.BaseNavigationActivity

/**
 * Created by Yshen
 * On 2019-10-29
 */
class ActivityActivity : BaseNavigationActivity() {

    override fun getLayoutId(): Int = R.layout.activity_activity

    override fun getFragmentId(): Int = R.id.fragment

    override fun afterViews() {

    }

}