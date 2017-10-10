package com.fengniao.myblibli.widget.tablayout

import android.app.Activity
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.widget.Scroller
import android.widget.TextView

class DynameicLine : View {
    private var startX: Float = 0.toFloat()
    private var stopX: Float = 0.toFloat()
    private var mPaint: Paint? = null
    private var mScroller: Scroller? = null
    private var defaultScroll: Boolean = false

    private var location1: Int = 0
    private var location2: Int = 0
    private var location3: Int = 0

    private val mRectF: RectF = RectF(startX, 0.toFloat(), stopX, 0.toFloat())


    constructor(context: Context?) : super(context) {
        init()
    }



    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint!!.isAntiAlias = true
        mPaint!!.style = Paint.Style.FILL
        mPaint!!.strokeWidth = 5.toFloat()
        mPaint!!.shader = LinearGradient(0.toFloat(), 100.toFloat(), getScreenWidth(context as Activity).toFloat(), 100.toFloat(),
                Color.parseColor("#ffc125"), Color.parseColor("#ff4500"), Shader.TileMode.MIRROR)

        mScroller = Scroller(context)
    }


    private fun getScreenWidth(activity: Activity): Int {
        val dm: DisplayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMeasure: Int = MeasureSpec.makeMeasureSpec(20, MeasureSpec.getMode(heightMeasureSpec))
        super.onMeasure(widthMeasureSpec, heightMeasure)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mRectF.set(startX, 0.toFloat(), stopX, 10.toFloat())
        canvas!!.drawRoundRect(mRectF, 5.toFloat(), 5.toFloat(), mPaint)
    }

    fun updateView(startX: Float, stopX: Float) {
        this.startX = startX
        this.stopX = stopX
        invalidate()
    }

//    private var sportL: Int = 0
//    fun setLocation(location1: Int, location2: Int, location3: Int, defaultScroll: Boolean) {
//        sportL = 0
//        this.defaultScroll = defaultScroll
//        this.location1 = location1
//        this.location2 = location2
//        this.location3 = location3
//        if (defaultScroll) {
//            stopX = location3.toFloat()
//            mScroller!!.startScroll(location1, 0, location2 - location1, 0, 2000)
//
//        } else {
//            startX = location1.toFloat()
//            mScroller!!.startScroll(location2, 0, location3 - location2, 0, 2000)
//        }
//        //必须调用此方法，以确定computeScroll会被盗用，否则不一定会刷新界面
//        invalidate()
//    }
//
//    override fun computeScroll() {
//        super.computeScroll()
//        //判断滚动是否完成
//        if (mScroller!!.computeScrollOffset()) {
//            if (defaultScroll) {
//                startX = mScroller!!.currX.toFloat()
//            } else {
//                sportL = mScroller!!.currX
//                stopX = (location3 - sportL).toFloat()
//            }
//            //必须调用此方法，否则不一定看到滚动效果
//            postInvalidate()
//        }
//    }

    // 得到使用该paint写上text的时候,像素为多少
    fun getTextViewLength(textView: TextView, text: String): Float =
            textView.paint.measureText(text)


}
