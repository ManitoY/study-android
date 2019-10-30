package com.yshen.study.components.activity

import android.widget.TextView
import com.yshen.study.base.BaseQuizFragment
import com.yshen.study.R
import org.w3c.dom.Text

/**
 * Created by Yshen
 * On 2019-10-29
 */
class ActivityQuizFragment : BaseQuizFragment() {

    companion object {
        private const val QUIZ_1 = "四种 LaunchMode 及其使用场景？"
        private const val ANSWER_TITLE_1_1 = "standard 模式"
        private const val ANSWER_CONTENT_1_1 = "默认模式。"
        private const val ANSWER_TITLE_1_2 = "singleTop 模式"
        private const val ANSWER_CONTENT_1_2 = "如果栈顶存在该实例，就重用并调用 onNewIntent。否则就会重新创建实例并放在栈顶，不管栈中是否存在该实例。"
        private const val ANSWER_TITLE_1_3 = "singleTask 模式"
        private const val ANSWER_CONTENT_1_3 = "如果栈中存在该实例，就重用并调用 onNewIntent，然后将它上面的实例全部移出栈。如果栈中不存在该实例，就会创建新的实例放入栈中。"
        private const val ANSWER_TITLE_1_4 = "singleInstance 模式"
        private const val ANSWER_CONTENT_1_4 = "如果存在该实例，就重用并调用 onNewIntent。否则就会重新创建一个新栈，并将该实例放入新栈中。"
        private const val QUIZ_2 = "onStart 和 onResume 有什么区别？"
        private const val ANSWER_2 = "onStart 和 onResume 都表示 Activity 已经可见了，但是 onStart 的时候 Activity 还在后台，onResume 的时候 Activity 才显示到前台。"
    }

    override fun getContentView(): Int = R.layout.layout_activity_quiz

    override fun setTextViewContent() {
        getViewById<TextView>(R.id.quiz1)?.text = QUIZ_1
        getViewById<TextView>(R.id.answerTitle1_1)?.text = ANSWER_TITLE_1_1
        getViewById<TextView>(R.id.answerContent1_1)?.text = ANSWER_CONTENT_1_1
        getViewById<TextView>(R.id.answerTitle1_2)?.text = ANSWER_TITLE_1_2
        getViewById<TextView>(R.id.answerContent1_2)?.text = ANSWER_CONTENT_1_2
        getViewById<TextView>(R.id.answerTitle1_3)?.text = ANSWER_TITLE_1_3
        getViewById<TextView>(R.id.answerContent1_3)?.text = ANSWER_CONTENT_1_3
        getViewById<TextView>(R.id.answerTitle1_4)?.text = ANSWER_TITLE_1_4
        getViewById<TextView>(R.id.answerContent1_4)?.text = ANSWER_CONTENT_1_4
        getViewById<TextView>(R.id.quiz2)?.text = QUIZ_2
        getViewById<TextView>(R.id.answer2)?.text = ANSWER_2
    }
}