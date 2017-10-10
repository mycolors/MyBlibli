package com.fengniao.myblibli.module.home.homepage.recommend

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fengniao.myblibli.R
import com.fengniao.myblibli.base.BaseListFragment
import com.fengniao.myblibli.base.FNAdapter
import com.fengniao.myblibli.bean.recommend.RecommendBannerData
import com.fengniao.myblibli.bean.recommend.RecommendPageResult
import com.fengniao.myblibli.net.HttpClient
import com.fengniao.myblibli.widget.circleviewpager.CircleViewPager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RecommendFragment : BaseListFragment<Any>() {


    override fun enableLazyLoad(): Boolean = false


    override fun loadData() {
        HttpClient.getInstance().recommendService
                .getRecommendBannerData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { t -> return@map handlerBannerData(t.data) }
                .observeOn(Schedulers.io())
                .flatMap { t ->
                    mList.clear()
                    mList.add(t)
                    return@flatMap HttpClient.getInstance()
                            .recommendService.getRecommendData()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: RecommendPageResult? ->
                    if (t != null)
                        handlerRecommendPageData(t.result)
                })
                { t: Throwable? ->
                    setListAdapter()
                    if (t != null)
                        System.out.println(t.localizedMessage)
                }
    }


    private fun handlerBannerData(urls: List<RecommendBannerData>): List<String> {
        val list: MutableList<String> = ArrayList()
        for (url in urls) {
            val imgUrl: String = url.image!!
            list.add(imgUrl)
        }
        return list
    }

    private fun handlerRecommendPageData(datas: List<RecommendPageResult.RecommendPageData>) {
        datas.forEach { t: RecommendPageResult.RecommendPageData? ->
            if (t != null) {
                mList.addAll(t.body!!)
            }
        }
        setListAdapter()
    }


    override fun onCreateLayoutManager(): RecyclerView.LayoutManager {
        val gridLayoutManager = GridLayoutManager(context, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = when (position) {
                0 -> 2
                else -> 1
            }
        }
        return gridLayoutManager
    }


    override fun getItemViewType(position: Int): Int {
        return if (mList[position] is List<*>)
            1
        else
            2
    }

    override fun getView(parent: ViewGroup, viewType: Int): View {
        return if (viewType == 1)
            LayoutInflater.from(context).inflate(R.layout.item_list_recommend_banner, parent, false)
        else
            LayoutInflater.from(context).inflate(R.layout.item_list_recommend, parent, false)
    }

    override fun bindDataToView(holder: FNAdapter.MyViewHolder, position: Int) {
        if (holder.itemViewType == 1) {
            holder.getView<CircleViewPager>(R.id.banner_pager).setImgUrl(
                    mList[position] as MutableList<String>)
        }
        if (mList.get(position) is RecommendPageResult.Body) {
            Glide.with(context).load((mList.get(position) as RecommendPageResult.Body).cover).into(holder.getView(R.id.img_video))
            holder.setText(R.id.text_title, (mList.get(position) as RecommendPageResult.Body).title)
        }
    }

    override fun onItemClick(holder: FNAdapter.MyViewHolder, position: Int) {

    }

    companion object {
        fun newInstance(): RecommendFragment = RecommendFragment()
    }


    override fun getLayoutId(): Int = R.layout.fragment_recommend

}
