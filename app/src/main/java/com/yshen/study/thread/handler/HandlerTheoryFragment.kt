package com.yshen.study.thread.handler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.yshen.study.R
import com.yshen.study.customview.animation.AnimationUtil
import kotlinx.android.synthetic.main.fragment_handler_theory.view.*

/**
 * Created by Yshen
 * On 2019-10-29
 */
class HandlerTheoryFragment : Fragment() {

    companion object {
        // MessageQueue
        private const val MESSAGEQUEUE = "消息队列，采用单链表的数据结构存储消息列表。"
        // Looper
        private const val LOOPER =
            "消息循环，会以无限循环的形式去查找是否有新消息，有就处理，没有就等待。一个线程只能创建一个 Looper，主线程 ActivityThread 被创建时就会初始化 Looper。"
        // ThreadLocal
        private const val THREADLOCAL = "可以在不同的线程中互不干扰地存储并提供数据。在 Handler 中 当前线程的 Looper 就是从这里面获取的。"
    }

    private val layout by lazy { View.inflate(activity, R.layout.fragment_handler_theory, null) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setCaseBtnClick()
        setCaseBtnAnim()
        return layout
    }

    /**
     * 面试题按钮点击事件
     */
    private fun setCaseBtnClick() {
        layout.caseBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quiz)
        }
    }

    /**
     * 面试题按钮动画
     */
    private fun setCaseBtnAnim() {
        if (layout.scrollView.height >= layout.contentLayout.height) {
            startAnim()
        }
        layout.scrollView.setOnScrollChangeListener { v: NestedScrollView?, _: Int, scrollY: Int, _: Int, _: Int ->
            if(scrollY + (v?.height ?: 0) == layout.contentLayout.height) {
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
        AnimationUtil.startShakeByPropertyAnim(layout.caseBtn, 0.8f, 1.2f, 5f, 1000)
    }

    /**
     * 停止动画
     */
    private fun stopAnim() {
        layout.caseBtn.animation?.cancel()
    }
}