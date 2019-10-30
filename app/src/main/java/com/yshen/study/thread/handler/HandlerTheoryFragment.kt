package com.yshen.study.thread.handler

import com.yshen.study.R
import com.yshen.study.base.BaseTheoryFragment

/**
 * Created by Yshen
 * On 2019-10-29
 */
class HandlerTheoryFragment : BaseTheoryFragment() {


    companion object {
        // MessageQueue
        private const val MESSAGEQUEUE = "消息队列，采用单链表的数据结构存储消息列表。"
        // Looper
        private const val LOOPER =
            "消息循环，会以无限循环的形式去查找是否有新消息，有就处理，没有就等待。一个线程只能创建一个 Looper，主线程 ActivityThread 被创建时就会初始化 Looper。"
        // ThreadLocal
        private const val THREADLOCAL = "可以在不同的线程中互不干扰地存储并提供数据。在 Handler 中 当前线程的 Looper 就是从这里面获取的。"
    }

    override fun setTextViewContent() {

    }

    override fun getContentView(): Int = R.layout.layout_handler_theory

    override fun getTheoryActionId(): Int = R.id.handler_quiz_action
}