package com.example.canvasapplication

import android.content.Context
import android.graphics.*
import android.text.*
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.view.View

class GraphicView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var bitmap: Bitmap? = null

    val paint = Paint().apply {
        isAntiAlias = true
        color = Color.GREEN
        strokeWidth = 30f
        strokeCap = Paint.Cap.ROUND
        style = Paint.Style.STROKE
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.android)
    }

    val textPaint = TextPaint().apply {
        flags = Paint.ANTI_ALIAS_FLAG
        color = Color.parseColor("#16a085")
        textSize = 50f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawPoint(100f, 200f, paint)

//        val stopX = width / 2
//        val stopY = height / 2
//        canvas?.drawLine(0f, 0f, stopX.toFloat(), stopY.toFloat(), paint)

//        val rectWidth = 300
//        val rectHeight = 150
//        val left = (width - rectWidth) / 2
//        val top = (height - rectHeight) / 2
//        val rect = Rect(left, top, left + rectWidth, top + rectHeight)
//        canvas?.drawRect(rect, paint)

//        val centerX = width / 2f
//        val centerY = height / 2f
//        canvas?.drawCircle(centerX, centerY, 500f, paint)

//        val ovalWidth = 300f
//        val ovalHeight = 100f
//        val left = (width - ovalWidth) / 2f
//        val top = (height - ovalHeight) / 2f
//        val rect = RectF(left, top, left + ovalWidth, top + ovalHeight)
//        canvas?.drawOval(rect, paint)

//        val arcWidth = 400
//        val arcHeight = 400
//        val left = (width - arcWidth) / 2f
//        val top = (height - arcHeight) / 2f
//        val rectF = RectF(left, top, left + arcWidth, top + arcHeight)
//        canvas?.drawArc(rectF, 45f, 270f, false, paint)
//        bitmap?.let {
//            val left = (width - it.width) / 2f
//            val top = (height - it.height)/ 2f
//            canvas?.drawBitmap(it, left, top, paint)
//        }

//        bitmap?.let {
//            val rectSrc = Rect(0, 0, it.width / 2, it.height / 2)
//            val left = width - rectSrc.width()
//            val top = height - rectSrc.height()
//
//            val rectDst = Rect(left, top, left + rectSrc.width(), top + rectSrc.height())
//            canvas?.drawBitmap(it, rectSrc, rectDst, paint)
//        }
        val text = "Canvas Android"
        val longText = "We can actually use any custom font that we'd like within our applications."
        val strElip =
            TextUtils.ellipsize(longText, textPaint, width.toFloat(), TextUtils.TruncateAt.MARQUEE)
        canvas?.drawText(text, 100f, 400f, textPaint)
        canvas?.drawText(text, 1, text.length - 1, 200f, 500f, textPaint)
        canvas?.drawText(strElip, 0, strElip.length, 0f, 300f, textPaint)

        val wordToSpan = SpannableString(strElip)
        wordToSpan.run {
            setSpan(StyleSpan(Typeface.BOLD), 0, 10, Spanned.SPAN_MARK_MARK)
        }
        val staticLayout =
            StaticLayout(
                wordToSpan, textPaint, width, Layout.Alignment.ALIGN_NORMAL,
                1f, 0f, false
            )
        staticLayout.draw(canvas)
    }
}
