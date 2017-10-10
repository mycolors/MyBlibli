package com.fengniao.myblibli.widget.tablayout

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView


class ViewPagerTitle : HorizontalScrollView {

    private var textViews: MutableList<TextView> = mutableListOf()
    private var titles: Array<String>? = null
    private var onTextViewClick: OnTextViewClick? = null
    private var mDynameicLine: DynameicLine? = null
    private var mViewPager: ViewPager? = null
    private var myOnPageChangeListener: MyOnPageChangeListener? = null
    private var mHorizontalScrollView: HorizontalScrollView? = null
    private var defaultMargin: Int = 0
    private var defaultTextSize = 18f
    private var selectedTextSize = 22f
    private var defaultTextColor = Color.GRAY
    private var selectedTextColor = Color.BLACK
    private var allTextViewLength: Int = 0


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
        //隐藏滚动条
        isHorizontalScrollBarEnabled = false
    }

    fun initData(titles: Array<String>, viewPager: ViewPager, defaultIndex: Int) {
        this.titles = titles
        this.mViewPager = viewPager
        createDynameicLine()
        createTextViews(titles)
        setCurrentItem(defaultIndex)

        val fixLeftDis = getFixLeftDis()

        myOnPageChangeListener = MyOnPageChangeListener(context, mViewPager!!, this.mDynameicLine!!,
                this, allTextViewLength, defaultMargin, fixLeftDis)
        mViewPager!!.addOnPageChangeListener(myOnPageChangeListener)
    }


    fun getFixLeftDis(): Int {
        val textView = TextView(context)
        textView.textSize = defaultTextSize
        textView.text = titles!![0]
        val defaultTextSize = getTextViewLength(textView)
        textView.textSize = selectedTextSize
        val selectedTextSize = getTextViewLength(textView)
        return (selectedTextSize - defaultTextSize) / 2
    }

    private fun createDynameicLine() {
        val params: ViewGroup.LayoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mDynameicLine = DynameicLine(context)
        mDynameicLine!!.layoutParams = params
    }

    private fun createTextViews(titles: Array<String>) {
        val textLinear: LinearLayout = LinearLayout(context)
        val layoutParams: LayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textLinear.layoutParams = layoutParams
        textLinear.orientation = LinearLayout.HORIZONTAL
        defaultMargin = getTextViewMargins(titles)

        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        params.setMargins(defaultMargin, 0, defaultMargin, 0)

        for (i in 0 until titles.size) {
            val textView: TextView = TextView(context)
            textView.text = titles[i]
            textView.setTextColor(Color.GRAY)
            textView.textSize = defaultTextSize
            textView.layoutParams = params
            textView.gravity = Gravity.CENTER_HORIZONTAL
            textView.setOnClickListener(onClickListener)
            textView.tag = i
            textViews.add(textView)
            textLinear.addView(textView)
        }
        val linearLayout: LinearLayout = LinearLayout(context)
        val linearLayoutPrams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.addView(textLinear)
        linearLayout.addView(mDynameicLine)
        addView(linearLayout, linearLayoutPrams)
        linearLayout.isMeasureWithLargestChildEnabled
    }

    private fun getTextViewMargins(titles: Array<String>): Int {
        val defaultMargins = 10
        var countLength = 0f
        val textView = TextView(context)
        textView.textSize = defaultTextSize
        val paint = textView.paint

        for (i in titles.indices) {
            countLength = countLength + defaultMargins.toFloat() + paint.measureText(titles[i]) + defaultMargins.toFloat()
        }
        val screenWidth = getScreenWidth(context as Activity)

        if (countLength <= screenWidth) {
            allTextViewLength = screenWidth
            return (screenWidth / titles.size - paint.measureText(titles[0]).toInt()) / 2
        } else {
            allTextViewLength = countLength.toInt()
            return defaultMargins
        }
    }


    private val onClickListener: OnClickListener = OnClickListener { v ->
        for (i in 0 until textViews.size) {
            if (i == v.tag) {
                (v as TextView).setTextColor(Color.BLACK)
                v.textSize = selectedTextSize
            } else {
                textViews[i].setTextColor(Color.GRAY)
                textViews[i].textSize = defaultTextSize
            }
        }
        mViewPager!!.currentItem = v.tag as Int
        if (onTextViewClick != null) onTextViewClick!!.textViewClick(v as TextView, v.tag as Int)
    }

    fun setCurrentItem(index: Int) {
        for (i in 0 until textViews.size) {
            if (i == index) {
                textViews[i].setTextColor(selectedTextColor)
                textViews[i].textSize = selectedTextSize
            } else {
                textViews[i].setTextColor(defaultTextColor)
                textViews[i].textSize = defaultTextSize
            }
        }
    }

    fun getTextView(): List<TextView> = textViews

    fun getTextLinearWidth(): Int {
        var width: Int = 0
        for (textView in textViews) {
            width += textView.width
        }
        return width
    }

    private fun getScreenWidth(activity: Activity): Int {
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    public fun getTextViewLength(textView: TextView): Int =
            textView.paint.measureText(textView.text.toString()).toInt()

    public interface OnTextViewClick {
        fun textViewClick(textView: TextView, index: Int)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mViewPager!!.removeOnPageChangeListener(myOnPageChangeListener)
    }
}

