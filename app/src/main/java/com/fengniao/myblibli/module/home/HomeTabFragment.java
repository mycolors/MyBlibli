package com.fengniao.myblibli.module.home;


import android.support.v4.app.Fragment;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseTabFragment;
import com.fengniao.myblibli.module.dynamic.DynamicPageFragment;
import com.fengniao.myblibli.module.home.homepage.HomePageFragment;
import com.fengniao.myblibli.module.message.MessagePageFragment;
import com.fengniao.myblibli.module.region.RegionPageFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabFragment extends BaseTabFragment {


    public static HomeTabFragment newInstance() {
        return new HomeTabFragment();
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
}
