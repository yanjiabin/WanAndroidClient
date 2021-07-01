package com.asa.wanandroid.ui.fragment

import android.util.Log
import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.mvp.contract.HomeContract
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.Banner
import com.asa.wanandroid.mvp.presenter.HomePresenter
import com.asa.wanandroid.ui.view.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(),
    HomeContract.View {

    private val linearLayoutManager = LinearLayoutManager(context)
    private val recyclerViewItemDecoration  by lazy {
        activity?.let {
            SpaceItemDecoration(it)
        }
    }
    private var pageNum = 0

    companion object {
        fun getInstance():HomeFragment= HomeFragment()
    }


    override fun scrollToTop() {

    }

    override fun setBanner(banners: List<Banner>) {

    }

    override fun setArticles(articles: ArticleResponseBody) {

    }

    override fun showCollectSuccess(success: Boolean) {

    }

    override fun showCancelCollectSuccess(success: Boolean) {

    }

    override fun attachlayoutRes(): Int = R.layout.fragment_home


    override fun initView(view: View) {
        super.initView(view)
        //        swipeRefreshLayout.setOnRefreshListener {
        pageNum = 0
        mPresenter?.requestHomeData()
//        }

        recyclerView?.apply {
            layoutManager =linearLayoutManager
            itemAnimator = DefaultItemAnimator()
            recyclerViewItemDecoration?.let {
                addItemDecoration(it)
            }
        }
    }

    override fun hideLoading() {
        super.hideLoading()
        swipeRefreshLayout?.isRefreshing = false
    }


    override fun lazyLoad() {

    }

    override fun createPresenter(): HomeContract.Presenter {
        return HomePresenter()
    }

    override fun userEventBus(): Boolean {
        return false
    }
}