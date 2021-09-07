package com.asa.wanandroid.ui.fragment

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.adapter.WechatViewPagerAdapter
import com.asa.wanandroid.mvp.contract.WeChatContract
import com.asa.wanandroid.mvp.model.bean.WXChapterBean
import com.asa.wanandroid.mvp.presenter.WeChatPresenter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_wechat.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class WeChatFragment:BaseMvpFragment<WeChatContract.View,WeChatContract.Presenter>(),WeChatContract.View {

    private val onTabSelectedListener = object :TabLayout.OnTabSelectedListener{
        override fun onTabSelected(tab: TabLayout.Tab?) {

        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {

        }

        override fun onTabReselected(tab: TabLayout.Tab?) {
            tab?.let {
                viewPager.setCurrentItem(it.position,false)
            }
        }
    }


    private val datas = mutableListOf<WXChapterBean>()

    private val viewPagerAdapter:WechatViewPagerAdapter by lazy {
        WechatViewPagerAdapter(datas,childFragmentManager)

    }

    companion object{
        fun getInstance():WeChatFragment= WeChatFragment()
    }
    override fun attachlayoutRes(): Int  = R.layout.fragment_wechat

    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view

        viewPager.apply {
            this.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        }
        tabLayout.apply {
            setupWithViewPager(viewPager)
            addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
            addOnTabSelectedListener(onTabSelectedListener)
        }

    }

    override fun showLoading() {
        multiple_status_view.showLoading()
    }

    override fun showError(errorMsg: String) {
        super.showError(errorMsg)
        multiple_status_view.showError()
    }

    override fun lazyLoad() {
        mPresenter?.getWXChapters()
    }

    override fun scrollToTop() {
        if (viewPagerAdapter.count == 0)return
        val knowledgeFragment :KnowledgeFragment = viewPagerAdapter.getItem(viewPager.currentItem) as KnowledgeFragment
        knowledgeFragment.scrollToTop()
    }

    override fun showWXChapters(chapters: MutableList<WXChapterBean>) {
        chapters.let {
            datas.addAll(it)
            doAsync {
                Thread.sleep(10)
                uiThread {
                    viewPager.run {
                        adapter = viewPagerAdapter
                        offscreenPageLimit = datas.size
                    }
                }
            }
        }
        if (chapters.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }
    }

    override fun createPresenter(): WeChatContract.Presenter {
        return WeChatPresenter()
    }

    override fun userEventBus(): Boolean {
        return false
    }
}