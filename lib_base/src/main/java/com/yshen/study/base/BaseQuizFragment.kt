package com.yshen.study.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_base_quiz.view.*

/**
 * Created by Yshen
 * On 2019-10-29
 */
abstract class BaseQuizFragment : Fragment() {
    private val layout by lazy { View.inflate(activity, R.layout.fragment_base_quiz, null) }
    protected var contentView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentView = View.inflate(activity, getContentView(), null)
        layout.scrollView.addView(contentView)
        setTextViewContent()
        return layout
    }

    @LayoutRes abstract  fun getContentView(): Int

    abstract fun setTextViewContent()
}