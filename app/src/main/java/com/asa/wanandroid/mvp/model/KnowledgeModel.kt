package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.KnowledgeContract
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.Observable
import io.reactivex.Observer

/**
 * create By：anderson
 * on 2021/9/7
 * desc:
 */
class KnowledgeModel:CommonModel(),KnowledgeContract.Model{
    override fun requestKnowledgeList(
        page: Int,
        cid: Int
    ): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.serviceApi.getKnowledgeList(page, cid)
    }


}