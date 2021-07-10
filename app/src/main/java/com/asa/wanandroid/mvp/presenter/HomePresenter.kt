package com.asa.wanandroid.mvp.presenter

import android.util.Log
import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.mvp.contract.HomeContract
import com.asa.wanandroid.mvp.model.HomeModel
import com.asa.wanandroid.mvp.model.bean.Article
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.utils.SettingUtil
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

class HomePresenter:CommonPresenter<HomeContract.Model,HomeContract.View>(),HomeContract.Presenter {

    override fun createModel() = HomeModel()

    override fun requestBanner() {
        mModel?.requestBanner()?.ss(mModel, mView, false) {
            mView?.setBanner(it.data)
        }
    }

    override fun requestArticles(num: Int) {
        mModel?.requestArticles(num)?.ss(mModel, mView, num == 0) {
            mView?.setArticles(it.data)
        }
    }

    override fun requestHomeData() {
        val observable = if (SettingUtil.getIsShowTopArticle()) {
            mModel?.requestArticles(0)
        }
        else {
            Observable.zip(mModel?.requestTopArticles(), mModel?.requestArticles(0),
                BiFunction<HttpResult<MutableList<Article>>, HttpResult<ArticleResponseBody>, HttpResult<ArticleResponseBody>> { t1, t2 ->
                    t1.data.forEach {
                        // 置顶数据中没有标识，手动添加一个标识
                        it.top = "1"
                    }
                    t2.data.datas.addAll(0, t1.data)
                    t2
                })
        }
        observable?.ss(mModel, mView, false) {
            mView?.setArticles(it.data)
        }

    }

}