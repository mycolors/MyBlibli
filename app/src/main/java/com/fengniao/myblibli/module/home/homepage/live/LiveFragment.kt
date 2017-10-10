package com.fengniao.myblibli.module.home.homepage.live

import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fengniao.myblibli.R
import com.fengniao.myblibli.base.BaseListFragment
import com.fengniao.myblibli.base.FNAdapter
import com.fengniao.myblibli.bean.live.*
import com.fengniao.myblibli.net.HttpClient
import com.fengniao.myblibli.widget.circleviewpager.CircleViewPager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*


class LiveFragment : BaseListFragment<Any>() {


    private val mDisposable: Disposable? = null


    //直播分类列表
    private var sortList: List<EntranceIcon>? = null


    override fun enableLazyLoad(): Boolean = true

    companion object {
        fun newInstance(): LiveFragment = LiveFragment()
    }


    override fun loadData() {
        HttpClient.getInstance()
                .liveApi
                .commonLiveList
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { commonLiveDataHttpResult ->
                    handleCommonData(commonLiveDataHttpResult.data)
                    sortList = commonLiveDataHttpResult.data.entranceIcons
                }
                .observeOn(Schedulers.io())
                .flatMap { HttpClient.getInstance().liveApi.recommendLiveList }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { recommendLiveDataHttpResult -> handleRecommendData(recommendLiveDataHttpResult.data) }
    }

    fun handleRecommendData(recommendLiveData: RecommendLiveData?) {
        if (recommendLiveData == null || mList.size < 0) return
        mList.add(1, recommendLiveData.recommend_data.partition)
        for (live in recommendLiveData.recommend_data.lives) {
            mList.add(2, live)
        }
        setListAdapter()
    }


    //处理数据
    fun handleCommonData(commonData: CommonLiveData?) {
        if (commonData == null) return
        showBanner(commonData.banner)
        for (partitions in commonData.partitions) {
            mList.add(partitions.partition)
            mList.addAll(partitions.lives)
        }
    }

    //获取banner数据
    fun showBanner(list: List<LiveBanner>) {
        val urlList = ArrayList<String>()
        for (banner in list) {
            urlList.add(banner.img)
        }

        mList.clear()
        mList.add(urlList)
    }


    override fun getItemViewType(position: Int): Int {
        if (position == 0) return 1
        if (mList[position] is Partition) return 2
        return if (mList[position] is Live) 3 else super.getItemViewType(position)
    }

    override fun getView(parent: ViewGroup, viewType: Int): View {
        when (viewType) {
            1 -> return activity.layoutInflater.inflate(R.layout.item_list_live_banner, parent, false)
            2 -> return activity.layoutInflater.inflate(R.layout.item_list_partition, parent, false)
            else -> return activity.layoutInflater.inflate(R.layout.item_list_live, parent, false)
        }
    }

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager? {
        val manager = GridLayoutManager(context, 2)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (mAdapter.getItemViewType(position)) {
                    1, 2 -> return 2
                    else -> return 1
                }
            }
        }
        return manager
    }

    override fun bindDataToView(holder: FNAdapter.MyViewHolder, position: Int) {
        //显示banner
        if (holder.itemViewType == 1) {
            holder.getView<CircleViewPager>(R.id.banner_pager)!!.setImgUrl(mList[position] as List<String>)
        }
        //显示直播partition
        if (mList[position] is Partition) {
            val partition = mList[position] as Partition
            holder.setText(R.id.text_partition_title, partition.name)
            val string = SpannableString("当前" + partition.count + "个直播")
            string.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),
                    2, string.length - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            holder.setText(R.id.text_end, string)
            val img = holder.getView<ImageView>(R.id.img_partition)
            Glide.with(context).load(partition.sub_icon!!.src).into(img!!)
        }
        //显示直播信息
        if (mList[position] is Live) {
            val live = mList[position] as Live
            holder.setText(R.id.text_live_title, live.title)
            holder.setText(R.id.text_up_name, live.owner.name)
            holder.setText(R.id.text_watch_count, live.online.toString() + "")
            val img = holder.getView<ImageView>(R.id.img_live)
            Glide.with(context).load(live.cover.src).into(img!!)
        }

    }

    override fun onItemClick(holder: FNAdapter.MyViewHolder, position: Int) {
        if (position == 0) {
            holder.getView<View>(R.id.linear_sort)!!.setOnClickListener { v ->
                if (sortList != null) {
                    val intent = Intent(context, LiveSortActivity::class.java)
                    intent.putParcelableArrayListExtra("sortList", sortList as ArrayList<out Parcelable>?)
                    jumpToActivity(intent)
                }
            }
        }
        if (mList[position] is Live) {
            val intent = Intent(context, LivePlayerActivity::class.java)
            intent.putExtra("live", mList[position] as Parcelable)
            jumpToActivity(intent)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_live

    override fun onDestroy() {
        super.onDestroy()
        if (mDisposable != null && !mDisposable.isDisposed)
            mDisposable.dispose()
    }

}