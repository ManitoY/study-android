package com.yshen.study.components.activity

import com.yshen.study.R
import com.yshen.study.base.BaseTheoryFragment

/**
 * Created by Yshen
 * On 2019-10-29
 */
class ActivityTheoryFragment : BaseTheoryFragment() {
    override fun getContentView(): Int = R.layout.layout_activity_theory

    override fun getTheoryActionId(): Int = R.id.activity_theory_action

    override fun setTextViewContent() {

    }
}