package com.yshen.study.components.activity

import android.widget.TextView
import com.yshen.study.base.BaseQuizFragment
import com.yshen.study.R

/**
 * Created by Yshen
 * On 2019-10-29
 */
class ActivityQuizFragment : BaseQuizFragment() {

    companion object {
        private const val QUIZ_1 = "四种 LaunchMode 及其使用场景？"
        private const val ANSWER_1 = "standard 模式\n" +
                "默认模式。\n" +
                "singleTop 模式\n" +
                "如果栈顶存在该实例，就重用并调用 onNewIntent( )。否则就会重新创建实例并放在栈顶，不管栈中是否存在该实例。\n" +
                "singleTask 模式\n" +
                "如果栈中存在该实例，就重用并调用 onNewIntent( )，然后将它上面的实例全部移出栈。如果栈中不存在该实例，就会创建新的实例放入栈中。\n" +
                "singleInstance 模式\n" +
                "如果存在该实例，就重用并调用 onNewIntent( )。否则就会重新创建一个新栈，并将该实例放入新栈中。"
    }

    override fun getContentView(): Int = R.layout.layout_activity_quiz

    override fun setTextViewContent() {
        contentView?.findViewById<TextView>(R.id.quiz1)?.text = QUIZ_1
        contentView?.findViewById<TextView>(R.id.answer1)?.text = ANSWER_1
    }
}