package com.fengniao.myblibli.module.dynamic;


import android.support.v4.app.Fragment;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseFragment;

/**
 * 动态页面
 * A simple {@link Fragment} subclass.
 */
public class DynamicPageFragment extends BaseFragment {


    public DynamicPageFragment() {
        // Required empty public constructor
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_dynamic_page;
    }

}
