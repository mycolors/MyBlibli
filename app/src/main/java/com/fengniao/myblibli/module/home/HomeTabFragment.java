package com.fengniao.myblibli.module.home;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseTabFragment;
import com.fengniao.myblibli.module.common.MainActivity;
import com.fengniao.myblibli.module.dynamic.DynamicPageFragment;
import com.fengniao.myblibli.module.home.homepage.HomePageFragment;
import com.fengniao.myblibli.module.message.MessagePageFragment;
import com.fengniao.myblibli.module.region.RegionPageFragment;

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
        final int[] offset = {0};

//        添加appbarlayout的折叠监听  verticalOffset表示折叠的像素
        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            //动态显示底部tab导航 方法一
//            ViewCompat.setTranslationY(linearTab, Math.abs(Float.parseFloat(UIUtils.getPercent(verticalOffset, toolbar.getHeight())))
//                    * linearTab.getHeight());
            if (offset[0] == verticalOffset) {
                return;
            }
            //方法二
            showOrHideTab(offset[0] < verticalOffset);
            offset[0] = verticalOffset;
        });
    }

    private void showOrHideTab(boolean show) {
        if (show) {
            showTab();
        } else {
            hideTab();
        }
    }

    private void showTab() {
        if (linearTab.getTranslationY() == 0) {
            return;
        }
        if (outAnima != null && outAnima.isRunning()) {
            outAnima.cancel();
        }
        if (inAnima == null) {
            inAnima = ObjectAnimator.ofFloat(linearTab, "translationY", linearTab.getTranslationY(), 0);
            inAnima.setDuration(200);
            inAnima.start();
            inAnima.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationCancel(Animator animation) {
                    super.onAnimationCancel(animation);
                    inAnima.removeAllListeners();
                    inAnima = null;
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    inAnima.removeAllListeners();
                    inAnima = null;
                }
            });
        } else {
            if (!inAnima.isRunning()) {
                inAnima.start();
            }
        }
    }

    private void hideTab() {
        if (linearTab.getTranslationY() ==
                linearTab.getHeight()) {
            return;
        }
        if (inAnima != null && inAnima.isRunning()) {
            inAnima.cancel();
        }
        if (outAnima == null) {
            outAnima = ObjectAnimator.ofFloat(linearTab, "translationY", linearTab.getTranslationY(),
                    linearTab.getHeight());
            outAnima.setDuration(200);
            outAnima.start();
            outAnima.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationCancel(Animator animation) {
                    super.onAnimationCancel(animation);
                    outAnima.removeAllListeners();
                    outAnima = null;
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    outAnima.removeAllListeners();
                    outAnima = null;
                }
            });
        } else {
            if (!outAnima.isRunning()) {
                outAnima.start();
            }
        }
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
