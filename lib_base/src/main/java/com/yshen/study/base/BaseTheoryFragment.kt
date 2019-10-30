package com.yshen.study.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.LayoutRes
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.yshen.study.common.Animations
import kotlinx.android.synthetic.main.fragment_base_theory.view.*

/**
 * Created by Yshen
 * On 2019-10-29
 */
abstract class BaseTheoryFragment : Fragment() {

    private val layout by lazy { View.inflate(activity, R.layout.fragment_base_theory, null) }
    protected var contentView: View? = null

    abstract fun setTextViewContent()

    @LayoutRes
    abstract  fun getContentView(): Int

    abstract fun getTheoryActionId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentView = View.inflate(activity, getContentView(), null)
        layout.scrollView.addView(contentView)
        setCaseBtnClick()
        setCaseBtnAnim()
        setTextViewContent()
        return layout
    }

    private fun setCaseBtnClick() {
        layout.findViewById<Button>(R.id.caseBtn).setOnClickListener {
            Navigation.findNavController(it).navigate(getTheoryActionId())
        }
    }

    /**
     * 面试题按钮动画
     */
    private fun setCaseBtnAnim() {
        if (layout.scrollView.height >= layout.scrollView.getChildAt(0).height) {
            startAnim()
        }
        layout.scrollView.setOnScrollChangeListener { v: NestedScrollView?, _: Int, scrollY: Int, _: Int, _: Int ->
            if(scrollY + (v?.height ?: 0) == layout.scrollView.getChildAt(0).height) {
                startAnim()
            } else {
                stopAnim()
            }
        }
    }

    /**
     * 开始动画
     */
    private fun startAnim() {
        Animations.startShakeByPropertyAnim(layout.caseBtn, 0.8f, 1.2f, 5f, 1000)
    }

    /**
     * 停止动画
     */
    private fun stopAnim() {
        layout.caseBtn.animation?.cancel()
    }
}