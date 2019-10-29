package com.yshen.study.customview.util

import android.content.Context

/**
 * Created by Yshen
 * On 2019-10-28
 * 屏幕相关的工具类
 */
object ScreenUtil {
    fun dpTopx(context: Context, dp: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}