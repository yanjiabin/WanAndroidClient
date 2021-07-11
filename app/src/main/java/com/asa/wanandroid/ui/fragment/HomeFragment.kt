package com.asa.wanandroid.ui.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.asa.common.utils.NetWorkUtil
import com.asa.wanandroid.App
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.adapter.HomeAdapter
import com.asa.wanandroid.ext.showSnackMsg
import com.asa.wanandroid.ext.showToast
import com.asa.wanandroid.mvp.contract.HomeContract
import com.asa.wanandroid.mvp.model.bean.Article
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.Banner
import com.asa.wanandroid.mvp.presenter.HomePresenter
import com.asa.wanandroid.ui.activity.LoginActivity
import com.asa.wanandroid.ui.view.SpaceItemDecoration
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
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
        if (success){
            showToast("收藏成功")
        }
    }

    override fun showCancelCollectSuccess(success: Boolean) {
        if (success){
            showToast("取消收藏成功")
        }
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

        homeAdapter.run {
            bindToRecyclerView(recyclerView)
            onItemChildClickListener = this@HomeFragment.onItemChildClickListener
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

    override fun showError(errorMsg: String) {
        super.showError(errorMsg)
        mLayoutStatusView?.showError()
        homeAdapter.run {
            if (isRefresh)
                setEnableLoadMore(true)
            else
                loadMoreFail()
        }
    }

    private val onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { adapter, view, position ->
        if (datas.size>0){
            val data = datas[position]
            when (view.id) {
                R.id.iv_like-> {
                    if (isLogin){
                        if (!NetWorkUtil.isNetworkAvailable(App.context)){
                            showSnackMsg("网络一次")
                            return@OnItemChildClickListener
                        }
                        val collect = data.collect
                        data.collect = !collect
                        homeAdapter.setData(position, data)
                        if (collect){
                            mPresenter?.addCollectArticle(data.id)
                        } else{
                            mPresenter?.cancelCollectArticle(data.id)
                        }
                    }else{
                        Intent(activity,LoginActivity::class.java).apply {
                            startActivity(this)
                        }
                    }
                }
                else -> {
                }
            }

        }

    }
}