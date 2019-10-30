package com.yshen.study.base

import android.view.View
import androidx.annotation.LayoutRes
import kotlinx.android.synthetic.main.fragment_base_quiz.view.*

/**
 * Created by Yshen
 * On 2019-10-29
 */
abstract class BaseQuizFragment : BaseFragment() {

    protected var contentView: View? = null

    override fun afterViews() {
        contentView = View.inflate(activity, getContentView(), null)
        layout.scrollView.addView(contentView)
        setTextViewContent()
    }

    override fun getLayoutId(): Int = R.layout.fragment_base_quiz

    @LayoutRes abstract  fun getContentView(): Int

    abstract fun setTextViewContent()
}