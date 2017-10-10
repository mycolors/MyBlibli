package com.fengniao.myblibli.widget.tablayout

import android.app.Activity
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.DisplayMetrics
import android.widget.TextView

class MyOnPageChangeListener : ViewPager.OnPageChangeListener {
    private var textViews: List<TextView>? = null
    private var mViewPagerTitle: ViewPagerTitle? = null
    private var mDynameicLine: DynameicLine? = null

    private var mViewPager: ViewPager? = null
    private var pagerCount: Int = 0
    private var screenWidth: Int = 0
    private var lineWidth: Int = 0
    private var everyLength: Int = 0
    private var lastPosition: Int = 0
    private var dis: Int = 0
    private var fixLeftDis: Int = 0

    private val location = IntArray(2)


    constructor(context: Context, viewPager: ViewPager, dynameicLine: DynameicLine, viewPagerTitle: ViewPagerTitle,
                allLength: Int, margin: Int, fixLeftDis: Int) {
        this.mViewPager = viewPager
        this.mViewPagerTitle = viewPagerTitle
        this.mDynameicLine = dynameicLine
        textViews = viewPagerTitle.getTextView()
        pagerCount = textViews!!.size
        screenWidth = getScreenWidth(context as Activity)

        lineWidth = getTextViewLength(textViews!![0])

        everyLength = allLength / pagerCount
        dis = margin
//        this.fixLeftDis = fixLeftDis

        //给view添加监听，便于在view绘制前获取view的宽高
        //不建议在这里做任何操作view的操作，因为view的绘制是多次发生的，所以这个方法会多次调用
//        viewPagerTitle.viewTreeObserver.addOnPreDrawListener {
//            everyLength = viewPagerTitle.getTextLinearWidth() / pagerCount
//            true
//        }
    }


    override fun onPageScrollStateChanged(state: Int) {
        val scrollRight: Boolean//页面向右
        if (state == ViewPager.SCROLL_STATE_SETTLING) {
            scrollRight = lastPosition < mViewPager!!.currentItem;
            lastPosition = mViewPager!!.currentItem
            if (lastPosition + 1 < textViews!!.size && lastPosition - 1 >= 0) {
                if (scrollRight)
                    textViews!![lastPosition + 1].getLocationOnScreen(location)
                else
                    textViews!![lastPosition - 1].getLocationOnScreen(location)
                if (location[0] > screenWidth) {
                    mViewPagerTitle!!.smoothScrollBy(screenWidth / 2, 0)
                } else if (location[0] < 0) {
                    mViewPagerTitle!!.smoothScrollBy(-screenWidth / 2, 0)
                }
            }
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        if (lastPosition > position) {
            if (positionOffset > 0.5) {
                mDynameicLine!!.updateView(((position + (positionOffset - 0.5) * 2) * everyLength + dis).toFloat()
                        , ((lastPosition + 1) * everyLength - dis).toFloat())
            } else {
                mDynameicLine!!.updateView((position * everyLength + dis).toFloat(),
                        ((lastPosition + positionOffset * 2) * everyLength - dis))
            }
        } else {
            if (positionOffset > 0.5) {
                mDynameicLine!!.updateView(((position + (positionOffset - 0.5) * 2) * everyLength + dis).toFloat(),
                        ((position + 2) * everyLength - dis).toFloat())
            } else {
                mDynameicLine!!.updateView((position * everyLength + dis).toFloat(),
                        (position + 1 + 2 * positionOffset) * everyLength - dis)
            }
        }

    }


    override fun onPageSelected(position: Int) {
        mViewPagerTitle!!.setCurrentItem(position)

    }


    private fun getScreenWidth(activity: Activity): Int {
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }


    public fun getTextViewLength(textView: TextView): Int =
            textView.paint.measureText(textView.text.toString()).toInt()


}