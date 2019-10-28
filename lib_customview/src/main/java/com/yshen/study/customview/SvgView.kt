package com.yshen.study.customview

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.PathParser
import com.yshen.study.customview.svg.SvgPath
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.math.max
import kotlin.math.min

/**
 * Created by Yshen
 * On 2019-10-25
 * 将 SVG 文件读取后绘制在界面上
 * 功能一: 可处理 <Path>
 * 功能二: 可点击 Path 区域，并监听点击事件
 */
class SvgView : View {

    private var c: Context? = null
    private val paint by lazy { Paint() }
    private var svgPathList: ArrayList<SvgPath>? = null
    private var totalRect: RectF? = null
    private var scale = 1.0f // 缩放比例

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
        c = context
        paint.isAntiAlias = true
        loadSvgThread.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //获取当前控件的高度 让 SVG 宽高适配当前控件
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        totalRect?.let {
            val mapWidth = it.width()
            scale = (width / mapWidth) //获取控件高度为了让 SVG 能缩放到和控件宽高适配
        }
        setMeasuredDimension(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        svgPathList?.let {
            canvas?.save()
            canvas?.scale(scale, scale)
            it.forEach { path ->
                path.drawInCanvas(canvas, paint)
            }
        }
    }

    private val loadSvgThread = object : Thread() {
        override fun run() {
            try {
                // 创建 DOM 解析器
                val doc = DocumentBuilderFactory.newInstance()
                // 得到 DOM 解析器对象
                val db = doc.newDocumentBuilder()
                // 把要解析的 SVG 文档转化为输入流，以便 DOM 解析器解析它
                val `is` = context.resources.openRawResource(R.raw.china)
                // 调用 DOM 解析器对象的 parse() 方法解析 SVG 文档，得到代表整个文档的 Document 对象，进行可以利用 DOM 特性对整个 SVG 文档进行操作了。
                val d = db.parse(`is`)
                // 得到 XML 文档的根节点
                val root = d.documentElement
                // 得到节点指定标签节点
                val paths = root.getElementsByTagName("path")
                // 获取 SVG 整个上下左右位置
                var left = -1f
                var top = -1f
                var right = -1f
                var bottom = -1f
                val list = ArrayList<SvgPath>()
                for (index in 0 until paths.length) {
                    val element = paths.item(index) as Element
                    val pathData = element.getAttribute("android:pathData")
                    val fillColor = element.getAttribute("android:fillColor")
                    val path = PathParser.createPathFromPathData(pathData)
                    val svgPath = SvgPath(path, fillColor)
                    val rectF = RectF()
                    path.computeBounds(rectF, true)
                    // 取出每个 Path 的上下左右，作比较
                    left =
                        left.takeIf { it == -1f }?.let { rectF.left } ?: min(left, rectF.left)
                    top =
                        top.takeIf { it == -1f }?.let { rectF.top } ?: min(top, rectF.top)
                    right =
                        right.takeIf { it == -1f }?.let { rectF.right } ?: max(right, rectF.right)
                    bottom =
                        bottom.takeIf { it == -1f }?.let { rectF.bottom } ?: max(
                            bottom,
                            rectF.bottom
                        )
                    list.add(svgPath)
                }
                svgPathList = list
                totalRect = RectF(left, top, right, bottom)

                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    requestLayout()
                    invalidate()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}