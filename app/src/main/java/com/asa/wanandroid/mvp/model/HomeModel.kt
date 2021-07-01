package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.HomeContract
import com.asa.wanandroid.mvp.model.bean.Article
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.Banner
import com.asa.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.Observable

class HomeModel: CommonModel(),HomeContract.Model {


    override fun requestBanner(): Observable<HttpResult<List<Banner>>> {
        return RetrofitHelper.serviceApi.getBanners()
    }

    override fun requestTopArticles(): Observable<HttpResult<MutableList<Article>>> {
        return RetrofitHelper.serviceApi.getTopArticles()
    }

    override fun requestArticles(num: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.serviceApi.getArticles(num)
    }


}