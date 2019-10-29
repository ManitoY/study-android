package com.yshen.study.thread.handler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yshen.study.R
import kotlinx.android.synthetic.main.fragment_handler_quiz.view.*

/**
 * Created by Yshen
 * On 2019-10-29
 */
class HandlerQuizFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity, R.layout.fragment_handler_quiz, null)
        setTextViewContent(view)
        return view
    }

    private fun setTextViewContent(view: View) {
        view.quiz1.text = QUIZ_1
        view.answer1.text = ANSWER_1
        view.code1.setCodeText(CODE_1)
        view.quiz2.text = QUIZ_2
        view.answer2.text = ANSWER_2
    }
}