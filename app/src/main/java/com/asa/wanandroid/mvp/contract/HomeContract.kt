package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.mvp.model.Article
import com.asa.wanandroid.mvp.model.ArticleResponseBody
import com.asa.wanandroid.mvp.model.Banner
import com.asa.wanandroid.mvp.model.HttpResult
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
interface HomeContract {

    interface View:CommonContract.View{

        fun scrollToTop()

        fun setBanner(banners: List<Banner>)

        fun setArticles(articles: ArticleResponseBody)
    }


    interface Presenter : CommonContract.Presenter<View> {

        fun requestBanner()

        fun requestHomeData()

        fun requestArticles(num: Int)

    }




    interface Model : CommonContract.Model {

        fun requestBanner(): Observable<HttpResult<List<Banner>>>

        fun requestTopArticles(): Observable<HttpResult<MutableList<Article>>>

        fun requestArticles(num: Int): Observable<HttpResult<ArticleResponseBody>>
    }


}