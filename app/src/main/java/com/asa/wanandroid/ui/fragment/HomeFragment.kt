package com.asa.wanandroid.ui.fragment

import android.util.Log
import android.view.View
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.mvp.contract.HomeContract
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.Banner
import com.asa.wanandroid.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(),
    HomeContract.View {

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