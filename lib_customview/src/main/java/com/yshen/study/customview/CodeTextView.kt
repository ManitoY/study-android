package com.yshen.study.customview

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.text.method.ScrollingMovementMethod
import android.util.AttributeSet
import android.widget.TextView
import com.yshen.study.customview.util.ScreenUtil

/**
 * Created by Yshen
 * On 2019-10-28
 * 将一段文字格式化成代码样式
 */
class CodeTextView : TextView {

    companion object {
        // padding
        private const val P = 10f
        // height
        private const val H = 30f
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context)
    }

    private fun init(context: Context) {
        val padding = ScreenUtil.dpTopx(context, P)
        setPadding(padding, padding, padding, padding)
        // 设置背景
        setBackgroundColor(Color.parseColor("#dfdfdf"))
        setTextColor(Color.parseColor("#000000"))
        setLineSpacing(0f,1.2f)
        movementMethod = ScrollingMovementMethod.getInstance()
        setHorizontallyScrolling(true)
        setCodeText()
    }

    fun setCodeText(text: String?) {
        this.text = text
        setCodeText()
    }

    /**
     * 将输入的字符串转化成代码格式显示
     */
    private fun setCodeText() {
        text = text.takeIf { it == null }?.let {
            height = ScreenUtil.dpTopx(context, H)
            ""
        } ?: replaceSpecialTag(text.toString())
    }

    private fun replaceSpecialTag(code: String?): Spanned? {
        val changed = code
            // 将字符串变成红色字体
            ?.let { str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("\"", pre)
                    if (pre == -1) break
                    beh = s.indexOf("\"", pre + 1)
                    if (beh == -1) break
                    s = s.replace(
                        pre,
                        beh + 1,
                        "<font color='#db254c'>" + s.substring(pre, beh + 1) + "</font>"
                    )
                    pre = beh + 30
                }
                s.toString()
            }
            // 将数组下标变成蓝色字体
            ?.let { str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("[", pre)
                    if (pre == -1) break
                    beh = s.indexOf("]", pre + 1)
                    if (beh == -1) break
                    s = s.replace(
                        pre + 1,
                        beh,
                        "<font color='#007575'>" + s.substring(pre + 1, beh) + "</font>"
                    )
                    pre = beh + 30
                }
                s.toString()
            }
            // 将注释变成灰色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("//", pre)
                    if (pre == -1) break
                    beh = s.indexOf("\n", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    s = s.replace(
                        pre,
                        beh + 1,
                        "<font color='#999999'><b>" + s.substring(pre, beh + 1) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            // 类名变成蓝色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("class", pre)
                    if (pre == -1) break
                    beh = s.indexOf("{", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    s = s.replace(
                        pre + 5,
                        beh,
                        "<font color='#3b4b7d'><b>" + s.substring(pre + 5, beh) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            // 方法体变成红色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("public", pre)
                    if (pre == -1) break
                    beh = s.indexOf("(", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    if (s.substring(pre + 6, beh + 1).contains("\n")) {
                        pre += 1
                        continue
                    }
                    s = s.replace(
                        pre + 6,
                        beh,
                        "<font color='#8e0002'><b>" + s.substring(pre + 6, beh) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            // 方法体变成红色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("private", pre)
                    if (pre == -1) break
                    beh = s.indexOf("\n", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    if (s.substring(pre + 7, beh + 1).contains("\n")) {
                        pre += 1
                        continue
                    }
                    s = s.replace(
                        pre + 7,
                        beh,
                        "<font color='#8e0002'><b>" + s.substring(pre + 7, beh) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            // 方法体变成红色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("protected", pre)
                    if (pre == -1) break
                    beh = s.indexOf("\n", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    if (s.substring(pre + 9, beh + 1).contains("\n")) {
                        pre += 1
                        continue
                    }
                    s = s.replace(
                        pre + 9,
                        beh,
                        "<font color='#8e0002'><b>" + s.substring(pre + 9, beh) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            // 方法体变成红色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("void", pre)
                    if (pre == -1) break
                    beh = s.indexOf("(", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    if (s.substring(pre + 4, beh + 1).contains("\n")) {
                        pre += 1
                        continue
                    }
                    s = s.replace(
                        pre + 4,
                        beh,
                        "<font color='#8e0002'><b>" + s.substring(pre + 4, beh) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            // 方法体变成红色字体
            ?.let {  str ->
                var pre = 0
                var beh: Int
                var s = StringBuilder(str)
                while (pre > -1) {
                    pre = s.indexOf("fun", pre)
                    if (pre == -1) break
                    beh = s.indexOf("(", pre + 1)
                    if (beh == -1) beh = s.length - 1
                    if (s.substring(pre + 6, beh + 1).contains("\n")) {
                        pre += 1
                        continue
                    }
                    s = s.replace(
                        pre + 3,
                        beh,
                        "<font color='#8e0002'><b>" + s.substring(pre + 3, beh) + "</b></font>"
                    )
                    pre = beh + 37
                }
                s.toString()
            }
            ?.replace("\n", "<br>")
            ?.replace("this", "<b color='#000000'>new</b>")
            ?.replace("new", "<b color='#000000'>new</b>")
            ?.replace("null", "<b color='#000000'>null</b>")
            ?.replace("public", "<b color='#000000'>public</b>")
            ?.replace("class", "<b color='#000000'>class</b>")
            ?.replace("byte", "<b color='#000000'>byte</b>")
            ?.replace("void", "<b color='#000000'>void</b>")
            ?.replace("private", "<b color='#000000'>private</b>")
            ?.replace("protected", "<b color='#000000'>protected</b>")
            ?.replace("throws", "<b color='#000000'>throws</b>")
            ?.replace("fun", "<b color='#000000'>fun</b>")
        return Html.fromHtml(changed)
    }
}