package com.also.a7_kotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.also.a7_kotlin.R
import com.also.base.core.utils.dp2px
import java.util.*

/**
 * 描述：
 * 作者：ye.yuan
 * 邮箱：galsomail@163.com
 * 创建时间：2020/9/17 10:41 PM
 */
class CodeView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    var paint = Paint()

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity=Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)

        paint.isAntiAlias=true
        paint.style= Paint.Style.STROKE
        paint.color = getContext().getColor(R.color.colorAccent)
        paint.strokeWidth = dp2px(6f)

        updateCode()
    }
    constructor(context: Context) : this(context, null)

    var codeList = arrayOf(
        "kotlin",
        "android",
        "java",
        "http",
        "https",
        "okhttp",
        "retrofit",
        "tcp/ip"
    )

    fun updateCode(){
        val random= Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)
    }
}