package com.asa.wanandroid.ui.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.asa.common.utils.NetWorkUtil
import com.asa.wanandroid.App
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.adapter.HomeAdapter
import com.asa.wanandroid.ext.showSnackMsg
import com.asa.wanandroid.ext.showToast
import com.asa.wanandroid.mvp.contract.SquareContract
import com.asa.wanandroid.mvp.model.bean.Article
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.presenter.SquaretPresenter
import com.asa.wanandroid.ui.activity.ContentActivity
import com.asa.wanandroid.ui.activity.LoginActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_refresh_layout.*

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class SquareFragment : BaseMvpFragment<SquareContract.View, SquareContract.Presenter>(),
    SquareContract.View {

    private var isRefresh = false

    private var pageSize= 20

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }


    companion object {
        fun getInstance(): SquareFragment = SquareFragment()
    }


    private val data = mutableListOf<Article>()
    private val mAdapter: HomeAdapter by lazy { HomeAdapter(activity, data) }
    override fun attachlayoutRes(): Int = R.layout.fragment_square

    override fun initView(view: View) {
        setHasOptionsMenu(true)
        super.initView(view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = mAdapter
        mAdapter.run {
            bindToRecyclerView(recyclerView)
            setOnLoadMoreListener(onRequestLoadMoreListener, recyclerView)
            onItemClickListener = this@SquareFragment.onItemClickListener
            onItemChildClickListener = this@SquareFragment.onItemChildClickListener
        }
        swipeRefreshLayout?.setOnRefreshListener(onRefreshListener)
    }


    private val onRefreshListener  = SwipeRefreshLayout.OnRefreshListener {
        isRefresh = true
        onRefreshList()
    }

    private val onRequestLoadMoreListener = BaseQuickAdapter.RequestLoadMoreListener {
        isRefresh = false
        swipeRefreshLayout.isRefreshing = false
        onLoadMoreList()
    }

    private val onItemChildClickListener =
        BaseQuickAdapter.OnItemChildClickListener { adapter, view, position ->
            if (data.size != 0) {
                val data = data[position]
                when (view.id) {
                    R.id.iv_like -> {
                        if (isLogin) {
                            if (!NetWorkUtil.isNetworkAvailable(App.context)) {
                                showSnackMsg(resources.getString(R.string.no_network))
                                return@OnItemChildClickListener
                            }
                            val collect = data.collect
                            data.collect = !collect
                            mAdapter.setData(position, data)
                            if (collect) {
                                mPresenter?.cancelCollectArticle(data.id)
                            } else {
                                mPresenter?.addCollectArticle(data.id)
                            }
                        } else {
                            Intent(activity, LoginActivity::class.java).run {
                                startActivity(this)
                            }
                            showToast(resources.getString(R.string.login_tint))
                        }
                    }
                }
            }
        }

    private val onItemClickListener =
        BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            if (data.size != 0){
                val itemData =data[position]
                ContentActivity.start(activity,itemData.id,itemData.title,itemData.link)
            }
        }



    override fun lazyLoad() {
        mLayoutStatusView?.showLoading()
        mPresenter?.getSquareList(0)
    }

    override fun scrollToTop() {
        recyclerView?.let {
            if (layoutManager is LinearLayoutManager){
                if (layoutManager.findFirstVisibleItemPosition() > 20){
                    it.scrollToPosition(0)
                } else{
                    it.smoothScrollToPosition(0)
                }
            }
        }
    }


    override fun hideLoading() {
        super.hideLoading()
        Log.e("日志", "hideLoading: ")
        if (isRefresh) {
            mAdapter.setEnableLoadMore(true)
        }
    }

    override fun showSquareList(body: ArticleResponseBody) {
        body.datas?.let {
            mAdapter.run {
                Log.e("日志", "showSquareList: ${isRefresh}")
                if (isRefresh) {
                    replaceData(it)
                } else {
                    addData(it)
                }
                pageSize = body.size
                if (body.over) {
                    loadMoreEnd()
                } else {
                    loadMoreComplete()
                }

            }
        }

        if (mAdapter.data.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
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
            showToast("已取消收藏")
        }
    }

    override fun createPresenter(): SquareContract.Presenter {
        return SquaretPresenter()
    }

    override fun userEventBus(): Boolean {
        return false
    }

    private fun onRefreshList() {
        mAdapter.setEnableLoadMore(false)
        mPresenter?.getSquareList(0)
    }


    private fun onLoadMoreList() {
        val page = mAdapter.data.size /pageSize
        mPresenter?.getSquareList(page)
    }
}