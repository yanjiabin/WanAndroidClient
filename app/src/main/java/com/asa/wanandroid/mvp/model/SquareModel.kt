package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.SquareContract
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/7/24
 * desc:
 */
class SquareModel:CommonModel(),SquareContract.Model {

    override fun getSquareList(page: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.serviceApi.getSquareList(page)
    }
}