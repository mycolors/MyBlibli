package com.fengniao.myblibli.module.home.homepage.recommend

import android.content.Intent
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
import com.fengniao.myblibli.module.home.homepage.live.LivePlayerActivity
import com.fengniao.myblibli.module.home.homepage.live.LivePlayerActivity.Companion.LIVE_AVATAR
import com.fengniao.myblibli.module.home.homepage.live.LivePlayerActivity.Companion.LIVE_TITLE
import com.fengniao.myblibli.module.home.homepage.live.LivePlayerActivity.Companion.LIVE_UP_NAME
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
        urls.mapTo(list) { it.image!! }
        return list
    }

    private fun handlerRecommendPageData(datas: List<RecommendPageResult.RecommendPageData>) {
        datas.forEach { t: RecommendPageResult.RecommendPageData? ->
            if (t != null) {
                mList.add(t.head)
                if (t.type == "live") {
                    t.body?.forEach { it.isLive = true }
                }
                mList.addAll(t.body!!)
            }
        }
        setListAdapter()
    }


    override fun onCreateLayoutManager(): RecyclerView.LayoutManager {
        val gridLayoutManager = GridLayoutManager(context, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = when (getItemViewType(position)) {
                1 -> 2
                2 -> 2
                else -> 1
            }
        }
        return gridLayoutManager
    }


    override fun getItemViewType(position: Int): Int {
        return if (mList[position] is List<*>)
            1
        else if (mList[position] is RecommendPageResult.Head)
            2
        else
            3
    }

    override fun getView(parent: ViewGroup, viewType: Int): View = when (viewType) {
        1 -> activity.layoutInflater.inflate(R.layout.item_list_recommend_banner, parent, false)
        2 -> activity.layoutInflater.inflate(R.layout.item_list_partition, parent, false)
        else -> LayoutInflater.from(context).inflate(R.layout.item_list_recommend, parent, false)
    }

    override fun bindDataToView(holder: FNAdapter.MyViewHolder, position: Int) {
        if (holder.itemViewType == 1) {
            holder.getView<CircleViewPager>(R.id.banner_pager).setImgUrl(
                    mList[position] as MutableList<String>)
        }
        //分类header
        if (mList[position] is RecommendPageResult.Head) {
            holder.setText(R.id.text_partition_title, (mList[position] as RecommendPageResult.Head).title)
            holder.setText(R.id.text_end, "更多")
        }
        //内容
        if (mList[position] is RecommendPageResult.Body) {
            Glide.with(context).load((mList[position] as RecommendPageResult.Body).cover).into(holder.getView(R.id.img_video))
            holder.setText(R.id.text_title, (mList[position] as RecommendPageResult.Body).title)
        }
    }

    override fun onItemClick(holder: FNAdapter.MyViewHolder, position: Int) {
        if (mList[position] is RecommendPageResult.Body
                && (mList[position] as RecommendPageResult.Body).isLive) {
            val body = mList[position] as RecommendPageResult.Body
            val intent: Intent = Intent(context, LivePlayerActivity::class.java)
            intent.putExtra(LIVE_TITLE, body.title)
            intent.putExtra(LIVE_UP_NAME, body.up)
            intent.putExtra(LIVE_AVATAR, body.cover)
            intent.putExtra(LIVE_TITLE, body.title)

        }
    }

    companion object {
        fun newInstance(): RecommendFragment = RecommendFragment()
    }


    override fun getLayoutId(): Int = R.layout.fragment_recommend

}
