package com.fengniao.myblibli.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.module.home.homepage.drama.DramaFragment;
import com.fengniao.myblibli.module.home.homepage.live.LiveFragment;
import com.fengniao.myblibli.module.home.homepage.recommend.RecommendFragment;


/**
 * 主页pageradapter
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private final String[] titles;
    private Fragment[] fragments;


    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.home_sections);
        fragments = new Fragment[titles.length];
    }


    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = LiveFragment.newInstance();
                    break;
                case 1:
                    fragments[position] = RecommendFragment.newInstance();
                    break;
                case 2:
                    fragments[position] = DramaFragment.newInstance();
                    break;
                default:
                    break;


            }
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
