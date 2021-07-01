package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.base.BaseModel
import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.CommonContract
import com.asa.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.Observable

open class CommonModel:BaseModel(),CommonContract.Model {

    override fun addCollectArticle(id: Int): Observable<HttpResult<Any>> {
        return RetrofitHelper.serviceApi.addCollectArticle(id)
    }

    override fun cancelCollectArticle(id: Int): Observable<HttpResult<Any>> {
        return RetrofitHelper.serviceApi.cancelCollectArticle(id)
    }
}