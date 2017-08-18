package com.fengniao.myblibli.widget.circleviewpager;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fengniao.myblibli.R;

import java.util.ArrayList;
import java.util.List;

public class CircleViewPager extends FrameLayout {
    private ViewPager mViewPager;
    private CirclePagerAdapter mAdapter;

    //图片对应的圆点合集
    private List<ImageView> mDotList;
    //圆点切换时间间隔
    private int interval;

    //选中时的圆点资源
    private int mSelectDotRes;

    //未选中是的圆点资源
    private int mNormalDotRes;

    //圆点半径
    private float mDotWidth;

    //当前位置
    private int currentPosition;

    //是否循环
    private boolean isLoop;

    private LinearLayout linearDot;

    private Handler mHandler = new Handler();

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            currentPosition++;
            mViewPager.setCurrentItem(currentPosition);
            mHandler.postDelayed(this, interval);
        }
    };

    public CircleViewPager(@NonNull Context context) {
        this(context, null);
    }

    public CircleViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleViewPager(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        setViewPagerAdapter();
    }

    //初始化
    public void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircleViewPager);
            mSelectDotRes = typedArray.getResourceId(R.styleable.CircleViewPager_selectPointRes, R.drawable.ic_select_dot);
            mNormalDotRes = typedArray.getResourceId(R.styleable.CircleViewPager_selectPointRes, R.drawable.ic_normal_dot);
            mDotWidth = typedArray.getDimension(R.styleable.CircleViewPager_dotWidth, 20);
            interval = typedArray.getInteger(R.styleable.CircleViewPager_interval, 3000);
            typedArray.recycle();
        }
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_pager_layout, this);
        linearDot = (LinearLayout) view.findViewById(R.id.linear_dot);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mDotList = new ArrayList<>();
    }

    //初始化viewpager
    private void setViewPagerAdapter() {
        if (mAdapter == null)
            mAdapter = new CirclePagerAdapter();
        mViewPager.setAdapter(mAdapter);
        setTouchListener();
        setPageChangeListener();
    }

    //设置图片
    public void setImage(List<ImageView> list) {
        if (list == null || mAdapter == null) return;
        mAdapter.setImage(list);
        initDot(list.size());
        if (list.size() > 1) {
            //设置默认位置
            currentPosition = 2 * list.size();
            mViewPager.setCurrentItem(currentPosition, false);
            //防止刷新数据后，还显示以前的图片，重新setAdapter
            mViewPager.setAdapter(mAdapter);
            startCircleViewPager();
        }
    }

    //初始化指示器
    private void initDot(int count) {
        linearDot.removeAllViews();
        mDotList.clear();
        for (int i = 0; i < count; i++) {
            ImageView imgDot = new ImageView(getContext());
            imgDot.setImageResource(mNormalDotRes);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) mDotWidth, (int) mDotWidth);
            params.setMargins((int) (mDotWidth / 1.5), (int) (mDotWidth / 1.5)
                    , (int) (mDotWidth / 1.5), (int) (mDotWidth / 1.5));
            linearDot.addView(imgDot, params);
            mDotList.add(imgDot);
        }
        selectionDot(currentPosition % count);
    }

    //选中指示器
    private void selectionDot(int index) {
        for (int i = 0; i < linearDot.getChildCount(); i++) {
            int res = i == index ? mSelectDotRes : mNormalDotRes;
            ((ImageView) linearDot.getChildAt(i)).setImageResource(res);
        }
    }

    private void setPageChangeListener() {
        mViewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        currentPosition = position;
                        if (!mDotList.isEmpty()) {
                            selectionDot(currentPosition % mDotList.size());
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        if (mDotList.size() > 1) {
                            //当检查到当前位置达到最前或者最后跳转到初始位置
                            if (currentPosition < mDotList.size() - 1 ||
                                    currentPosition > 9 * mDotList.size() - 1)
                                if (state == ViewPager.SCROLL_STATE_IDLE) {
                                    mViewPager.setCurrentItem(2 * mDotList.size()
                                            + currentPosition % mDotList.size() - 1, false);
                                }
                        }

                    }
                });
    }

    private void setTouchListener() {
        mViewPager.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    requestDisallowInterceptTouchEvent(true);
                case MotionEvent.ACTION_MOVE:
                    stopCircleViewPager();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    startCircleViewPager();
                    requestDisallowInterceptTouchEvent(false);
                default:
                    break;
            }
            return false;
        });
    }

    private void startCircleViewPager() {
        if (!isLoop && mViewPager != null) {
            mHandler.postDelayed(mRunnable, interval);
            isLoop = true;
        }
    }

    public void stopCircleViewPager() {
        if (isLoop && mViewPager != null) {
            mHandler.removeCallbacks(mRunnable);
            isLoop = false;
        }
    }


    //尽量避免使用，防止出现anr
    public void setCurrentItem(int item) {
        if (!mDotList.isEmpty()) {
            currentPosition = 2 * mDotList.size() + item;
            mViewPager.setCurrentItem(currentPosition);
        }
    }

    //尽量避免使用，防止出现anr
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (!mDotList.isEmpty()) {
            currentPosition = 2 * mDotList.size() + item;
            currentPosition = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mDotList.size() + item;
            mViewPager.setCurrentItem(currentPosition, smoothScroll);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startCircleViewPager();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopCircleViewPager();
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setmSelectDotRes(int mSelectDotRes) {
        this.mSelectDotRes = mSelectDotRes;
    }

    public void setmNormalDotRes(int mNormalDotRes) {
        this.mNormalDotRes = mNormalDotRes;
    }

    public void setmDotWidth(float mDotWidth) {
        this.mDotWidth = mDotWidth;
    }


}
