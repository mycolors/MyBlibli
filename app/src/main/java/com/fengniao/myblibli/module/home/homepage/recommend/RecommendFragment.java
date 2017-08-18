package com.fengniao.myblibli.module.home.homepage.recommend;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseFragment;

/**
 * 推荐
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment {
    public RecommendFragment() {
        // Required empty public constructor
    }


    public static RecommendFragment newInstance() {
        Bundle args = new Bundle();
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        loadData();
    }

    public void loadData() {
//        HttpClient.getInstance().getHomeApi()
//                .getRecommendInfo()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> Log.i("test", s));
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }


}
