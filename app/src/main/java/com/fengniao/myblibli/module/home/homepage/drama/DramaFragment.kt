package com.fengniao.myblibli.module.home.homepage.drama

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.fengniao.myblibli.R
import com.fengniao.myblibli.base.BaseListFragment
import com.fengniao.myblibli.base.FNAdapter
import com.fengniao.myblibli.bean.drama.DramaPageData
import com.fengniao.myblibli.bean.drama.RecommendDramaData
import com.fengniao.myblibli.net.HttpClient
import com.fengniao.myblibli.widget.circleviewpager.CircleViewPager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 番剧
 */
class DramaFragment : BaseListFragment<Any>() {
    override fun enableLazyLoad(): Boolean = true

    override fun loadData() {
        HttpClient.getInstance().dramaService
                .getDramaData()
                .doOnNext { t -> handleDramaData(t.result) }
                .flatMap { return@flatMap HttpClient.getInstance().dramaService.getRecommendDrama() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t -> handleRecommendDramaData(t.result) })
                { t: Throwable? ->
                    setListAdapter()
                    if (t != null) {
                        System.out.print(t.localizedMessage)
                    }
                }
    }

    internal data class Departition(var title: String, var type: Int)

    private fun handleDramaData(dramaData: DramaPageData) {
        mList.clear()
        val urlList: MutableList<String> = mutableListOf()
        dramaData.ad.head.mapTo(urlList) { it.img }
        mList.add(urlList)
        mList.add(Departition("新番连载", 1))
        mList.addAll(dramaData.serializing)
        mList.add(Departition(dramaData.previous.season.toString() + "月新番", 2))
        mList.addAll(dramaData.previous.list)
    }


    private fun handleRecommendDramaData(recommendDramaList: List<RecommendDramaData>) {
        mList.addAll(recommendDramaList)
        setListAdapter()
    }

    override fun getItemViewType(position: Int): Int = if (mList[position] is List<*>)
        1
    else if (mList[position] is Departition)
        2
    else if (mList[position] is DramaPageData.DramaInfo)
        3
    else
        4

    override fun getView(parent: ViewGroup?, viewType: Int): View = when (viewType) {
        1 -> LayoutInflater.from(context).inflate(R.layout.item_list_drama_banner, parent, false)
        2 -> LayoutInflater.from(context).inflate(R.layout.item_list_partition, parent, false)
        3 -> LayoutInflater.from(context).inflate(R.layout.item_list_drama, parent, false)
        else -> LayoutInflater.from(context).inflate(R.layout.item_list_drama_recommend, parent, false)
    }

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager {
        val gridManager = GridLayoutManager(context, 3)
        gridManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                    if (mAdapter.getItemViewType(position) == 3)
                        1
                    else
                        3
        }
        return gridManager
    }


    override fun bindDataToView(holder: FNAdapter.MyViewHolder?, position: Int) {
        if (holder != null) {
            if (holder.itemViewType == 1) {
                holder.getView<CircleViewPager>(R.id.banner_pager).setImgUrl(
                        mList[position] as MutableList<String>)
            }
            if (mList[position] is Departition) {
                holder.getView<TextView>(R.id.text_partition_title).text = (mList[position]as Departition).title
            }
            if (mList[position] is DramaPageData.DramaInfo) {
                Glide.with(context).load((mList[position] as DramaPageData.DramaInfo).cover)
                        .into(holder.getView(R.id.img_drama))
                holder.setText(R.id.text_drama_title, (mList[position] as DramaPageData.DramaInfo).title)
                holder.setText(R.id.text_watch_count, (mList[position] as DramaPageData.DramaInfo)
                        .watching_count.toString())
                holder.setText(R.id.text_progress, "更新至第" + (mList[position] as DramaPageData.DramaInfo)
                        .season_status + "话")
            }
            if (mList[position] is RecommendDramaData) {
                Glide.with(context).load((mList[position] as RecommendDramaData).cover)
                        .into(holder.getView(R.id.img_drama))
                holder.setText(R.id.text_drama_title, (mList[position] as RecommendDramaData).title)
                holder.setText(R.id.text_drama_info, (mList[position] as RecommendDramaData).desc)
            }
        }
    }

    override fun onItemClick(holder: FNAdapter.MyViewHolder?, position: Int) {
    }

    companion object {
        fun newInstance(): DramaFragment = DramaFragment()
    }


    override fun getLayoutId(): Int = R.layout.fragment_drama
}