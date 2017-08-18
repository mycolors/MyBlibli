package com.fengniao.myblibli.widget.circleviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class CirclePagerAdapter extends PagerAdapter {
    private List<ImageView> mList;

    public CirclePagerAdapter() {
        mList = new ArrayList<>();
    }

    public void setImage(List<ImageView> list) {
        if (mList == null) mList = new ArrayList<>();
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 10 * mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        if (!mList.isEmpty()) {
            ImageView imageView = mList.get(position % mList.size());
            ViewParent parent = imageView.getParent();
            if (parent != null) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(imageView);
            }
            container.addView(imageView);
            return imageView;
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
