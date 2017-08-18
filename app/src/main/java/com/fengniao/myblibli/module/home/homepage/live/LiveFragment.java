package com.fengniao.myblibli.module.home.homepage.live;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseListFragment;
import com.fengniao.myblibli.base.FNAdapter;
import com.fengniao.myblibli.bean.live.LiveBanner;
import com.fengniao.myblibli.net.HttpClient;
import com.fengniao.myblibli.util.UIUtils;
import com.fengniao.myblibli.widget.circleviewpager.CircleViewPager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 直播
 */
public class LiveFragment extends BaseListFragment<Object> {

    private CircleViewPager liveBanner;


    public LiveFragment() {
        // Required empty public constructor
    }

    @Override
    public boolean enableLazyLoad() {
        return true;
    }


    public static LiveFragment newInstance() {

        Bundle args = new Bundle();

        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    public void loadData() {
        HttpClient.getInstance()
                .getLiveApi()
                .getHomeLiveList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(httpResult -> {
                    showBanner(httpResult.getData().getBanner());
                });
    }

    public void showBanner(List<LiveBanner> list) {
        List<ImageView> imgList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ImageView view = new ImageView(getContext());
            Glide.with(this).load(list.get(i).getImg()).into(view);
            imgList.add(view);
            int finalI = i;
            view.setOnClickListener(v -> {
                UIUtils.showToast(finalI + "");

            });
        }
        mList.clear();
        mList.add(imgList);
        setListAdapter();
    }


    @Override
    public View getView(ViewGroup parent, int viewType) {
        return getActivity().getLayoutInflater().inflate(R.layout.item_list_live_banner, parent, false);
    }

    @Override
    public void bindDataToView(FNAdapter.MyViewHolder holder, int position) {
        if (liveBanner == null)
            liveBanner = holder.getView(R.id.banner_pager);
        liveBanner.setImage((List<ImageView>) mList.get(position));

    }

    @Override
    public void onItemClick(FNAdapter.MyViewHolder holder, int position) {

    }
}
