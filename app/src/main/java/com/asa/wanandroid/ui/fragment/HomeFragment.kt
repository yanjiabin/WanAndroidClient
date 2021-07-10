package com.asa.wanandroid.ui.fragment

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.adapter.HomeAdapter
import com.asa.wanandroid.mvp.contract.HomeContract
import com.asa.wanandroid.mvp.model.bean.Article
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.Banner
import com.asa.wanandroid.mvp.presenter.HomePresenter
import com.asa.wanandroid.ui.view.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_refresh_layout.*

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(),
    HomeContract.View {

    private val linearLayoutManager = LinearLayoutManager(context)

    private var isRefresh = true

    private val datas = mutableListOf<Article>()

    private var pageNum = 0
    private val homeAdapter :HomeAdapter by lazy { HomeAdapter(activity,datas) }

    private val recyclerViewItemDecoration by lazy {
        activity?.let {
            SpaceItemDecoration(it)
        }
    }

    private val onRefreshListener  = SwipeRefreshLayout.OnRefreshListener {
        isRefresh = true
        homeAdapter.setEnableLoadMore(false)
        mPresenter?.requestHomeData()
    }



    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }


    override fun scrollToTop() {

    }

    override fun setBanner(banners: List<Banner>) {

    }

    override fun setArticles(articles: ArticleResponseBody) {
        Log.e("日志", "setArticles: :${isRefresh}")
        articles.datas.let {
            homeAdapter.apply {
                if (isRefresh){
                    replaceData(it)
                } else{
                    addData(it)
                }
                val size =it.size
                if (size <  articles.size){
                    loadMoreEnd(isRefresh)
                } else{
                    loadMoreComplete()
                }
            }
        }

        if (homeAdapter.data.isEmpty()){
            mLayoutStatusView?.showEmpty()
        } else{
            mLayoutStatusView?.showContent()
        }
    }

    override fun showCollectSuccess(success: Boolean) {

    }

    override fun showCancelCollectSuccess(success: Boolean) {

    }

    override fun attachlayoutRes(): Int = R.layout.fragment_refresh_layout


    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        swipeRefreshLayout.run {
            setOnRefreshListener(onRefreshListener)
        }

        recyclerView?.apply {
            layoutManager = linearLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = homeAdapter
            recyclerViewItemDecoration?.let {
                addItemDecoration(it)
            }
        }
    }

    override fun hideLoading() {
        super.hideLoading()
        swipeRefreshLayout?.isRefreshing = false
        if (isRefresh){
            homeAdapter.run {
                setEnableLoadMore(true)
            }
        }
    }


    override fun lazyLoad() {
        Log.e("日志", "lazyLoad: ")
        mLayoutStatusView?.showLoading()
        mPresenter?.requestHomeData()
    }

    override fun createPresenter(): HomeContract.Presenter {
        return HomePresenter()
    }

    override fun userEventBus(): Boolean {
        return false
    }
}