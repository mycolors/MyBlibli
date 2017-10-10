package com.fengniao.myblibli.module.home.homepage

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import com.fengniao.myblibli.R
import com.fengniao.myblibli.adapter.HomePagerAdapter
import com.fengniao.myblibli.base.BaseFragment
import com.fengniao.myblibli.module.home.HomeTabFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

/**
 * 首页
 * A simple {@link Fragment} subclass.
 */
class HomePageFragment : BaseFragment() {
    private var viewPager: ViewPager? = null

    private var mTabLayout: TabLayout? = null



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (parentFragment is HomeTabFragment)
            mTabLayout = (parentFragment as HomeTabFragment).tabLayout
        viewPager = view_pager
        initViewPager()
    }


    private fun initViewPager() {
        val mAdapter = HomePagerAdapter(childFragmentManager, context)
        viewPager!!.offscreenPageLimit = 3
        viewPager!!.adapter = mAdapter
        if (mTabLayout != null)
            mTabLayout!!.setupWithViewPager(viewPager)
        viewPager!!.currentItem = 1
    }


    override fun getLayoutId(): Int = R.layout.fragment_home_page
}