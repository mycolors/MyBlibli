package com.fengniao.myblibli.module.home.homepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.adapter.HomePagerAdapter;
import com.fengniao.myblibli.base.BaseFragment;

import butterknife.BindView;

/**
 * 首页
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
    }


    private void initViewPager() {
        HomePagerAdapter mAdapter = new HomePagerAdapter(getChildFragmentManager(), getContext());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_page;
    }


}
