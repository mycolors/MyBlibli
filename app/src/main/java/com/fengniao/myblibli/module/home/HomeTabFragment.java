package com.fengniao.myblibli.module.home;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseTabFragment;
import com.fengniao.myblibli.module.common.MainActivity;
import com.fengniao.myblibli.module.dynamic.DynamicPageFragment;
import com.fengniao.myblibli.module.home.homepage.HomePageFragment;
import com.fengniao.myblibli.module.message.MessagePageFragment;
import com.fengniao.myblibli.module.region.RegionPageFragment;
import com.fengniao.myblibli.util.UIUtils;

import butterknife.BindView;


public class HomeTabFragment extends BaseTabFragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.linear_tab)
    LinearLayout linearTab;

    @BindView(R.id.cdt_layout)
    CoordinatorLayout cdtLayout;

    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;


    private ObjectAnimator inAnima;

    private ObjectAnimator outAnima;

    private float curTranslationY;


    public static HomeTabFragment newInstance() {
        return new HomeTabFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initToolbar();
        initAnima();
    }


    public void initToolbar() {
        toolbar.setTitle("");
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
    }


    private void initAnima() {
        curTranslationY = linearTab.getTranslationY();
        final int[] offset = {0};
        inAnima = ObjectAnimator.ofInt(linearTab, "translationY", (int) curTranslationY + linearTab.getHeight(), -linearTab.getHeight());
        outAnima = ObjectAnimator.ofInt(linearTab, "translationX", 0, 500, 0);
        inAnima.setDuration(2000);
        outAnima.setDuration(2000);
        outAnima.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.i("test", "end");
            }
        });

//        添加appbarlayout的折叠监听  verticalOffset表示折叠的像素
        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            ViewCompat.setTranslationY(linearTab, Math.abs(Float.parseFloat(UIUtils.getPercent(verticalOffset, toolbar.getHeight())))
                    * linearTab.getHeight());
//            showOrHideTab(offset[0] < verticalOffset);
//            offset[0] = verticalOffset;
        });
    }

    private void showOrHideTab(boolean show) {
        if (show) {
            if (curTranslationY != linearTab.getTranslationY())
                showTab();
        } else {
            if (curTranslationY == linearTab.getTranslationY())
                hideTab();
        }
    }

    private void showTab() {
        if (!inAnima.isRunning()) {
            inAnima.start();
        }
    }

    private void hideTab() {
        if (!outAnima.isRunning())
            outAnima.start();
    }


    @Override
    protected Class[] getFragmentClasses() {
        return new Class[]{HomePageFragment.class, RegionPageFragment.class,
                DynamicPageFragment.class, MessagePageFragment.class};
    }


    @Override
    protected int[] getStrings() {
        return new int[]{R.string.tab_home, R.string.tab_region, R.string.tab_dynamic,
                R.string.tab_message};
    }

    @Override
    protected int[] getIcons() {
        return new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    }

    @Override
    protected int getTextColor() {
        return R.color.color_tab_text;
    }

    @Override
    protected int firstPosition() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void onTabSelected(int position) {
        super.onTabSelected(position);
        if (position == 0) {
            tabLayout.setVisibility(View.VISIBLE);
        } else {
            tabLayout.setVisibility(View.GONE);
        }
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }


}
