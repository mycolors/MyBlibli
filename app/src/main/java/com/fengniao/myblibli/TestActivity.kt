package com.fengniao.myblibli

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.fengniao.myblibli.adapter.HomePagerAdapter
import com.fengniao.myblibli.base.BaseActivity
import com.fengniao.myblibli.widget.tablayout.ViewPagerTitle

class TestActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewPager: ViewPager = findViewById(R.id.view_pager) as ViewPager
        var viewPagerTitle: ViewPagerTitle = findViewById(R.id.view_pager_title) as ViewPagerTitle
        viewPagerTitle.initData(arrayOf("1", "2222", "3333"), viewPager, 0)
        var adapter = HomePagerAdapter(supportFragmentManager,this)
        viewPager.adapter = adapter
    }
}
