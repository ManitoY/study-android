package com.yshen.study.customview.svg

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

/**
 * Created by Yshen
 * On 2019-10-25
 */
class SvgPath(private val path: Path, private val color: String) {
    fun drawInCanvas(canvas: Canvas?, paint: Paint) {
        paint.strokeWidth = 1f
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path, paint)
    }
}