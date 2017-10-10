package com.fengniao.myblibli.module.home.homepage.live

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fengniao.myblibli.R
import com.fengniao.myblibli.base.BaseListActivity
import com.fengniao.myblibli.base.FNAdapter
import com.fengniao.myblibli.bean.live.EntranceIcon

class LiveSortActivity : BaseListActivity<EntranceIcon>() {

    override fun getLayoutId(): Int = R.layout.activity_live_sort

    override fun afterCreateView() {
        super.afterCreateView()
        title = "全部分类"
    }

    override fun loadData() {
        enableRefresh(false)
        val list = intent.getParcelableArrayListExtra<EntranceIcon>("sortList")
        if (list != null)
            mList.addAll(list)
        setListAdapter()
    }

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager? =
            GridLayoutManager(activity, 3)

    override fun getView(parent: ViewGroup, viewType: Int): View =
            layoutInflater.inflate(R.layout.item_list_live_sort, parent, false)

    override fun bindDataToView(holder: FNAdapter.MyViewHolder, position: Int) {
        holder.setText(R.id.text_sort, mList[position].name)
        val imageView = holder.getView<ImageView>(R.id.img_sort)
        val params = imageView!!.layoutParams
        params.width = mList[position].entrance_icon.width
        params.height = mList[position].entrance_icon.height
        imageView.layoutParams = params
        Glide.with(activity).load(mList[position].entrance_icon.src).into(imageView)

    }

    override fun onItemClick(holder: FNAdapter.MyViewHolder, position: Int) {

    }

}
