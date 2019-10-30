package com.yshen.study.thread.handler

import android.widget.TextView
import com.yshen.study.R
import com.yshen.study.base.BaseQuizFragment
import com.yshen.study.show.CodeTextView

/**
 * Created by Yshen
 * On 2019-10-29
 */
class HandlerQuizFragment : BaseQuizFragment() {


    companion object {
        private const val QUIZ_1 = "Android 为什么需要提供在某个具体的线程中执行任务这种功能呢？"
        private const val ANSWER_1 = "这是因为 Android 规定访问 UI 只能在主线程中进行，如果在子线程中访问 UI，那么程序就会抛出异常。ViewRootImpl 对 UI操作做了验证，这个验证工作是由 ViewRootImpl 的 checkThread 方法来完成的，如下所示。"
        /**
         * @link android.view.ViewRootImpl#checkThread
         */
        private const val CODE_1 = "void checkThread ( ) { \n" + "&#12288; " +
                "if (mThread != Thread.currentThread ( ) ) { \n" + "&#12288;&#12288;&#12288;" +
                "throw new CalledFromWrongThreadException ( \n" + "&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;" +
                "\"Only the original thread that created a view hierarchy can \n" + "&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;" +
                "touch its views.\"); \n" + "&#12288;&#12288;" +
                "} \n" +
                "}"

        private const val QUIZ_2 = "系统为什么不允许在子线程中访问 UI 呢？为什么系统不对 UI 控件的访问加上锁机制呢？"
        private const val ANSWER_2 = "这是因为 Android 的 UI 控件不是线程安全的，如果在多线程中并发访问可能会导致 UI 控件处于不可预期的状态。如果加上锁机制就会让 UI 访问的逻辑变得复杂；其次锁机制会降低 UI 访问的效率，因为锁机制会阻塞某些线程的执行。"
    }

    override fun getContentView(): Int = R.layout.layout_handler_quiz

    override fun setTextViewContent() {
        getViewById<TextView>(R.id.quiz1)?.text = QUIZ_1
        getViewById<TextView>(R.id.answer1)?.text = ANSWER_1
        getViewById<CodeTextView>(R.id.code1)?.setCodeText(CODE_1)
        getViewById<TextView>(R.id.quiz2)?.text = QUIZ_2
        getViewById<TextView>(R.id.answer2)?.text = ANSWER_2
    }
}