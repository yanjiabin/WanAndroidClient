package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.base.IView
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/9/7
 * desc:
 */
interface KnowledgeContract {


    interface View :CommonContract.View{
        fun scrollToTop()

        fun setKnowledgeList(articles: ArticleResponseBody)
    }

    interface Presenter:CommonContract.Presenter<View>{
        fun requestKnowledgeList(page: Int, cid: Int)
    }

    interface Model: CommonContract.Model{
        fun requestKnowledgeList(page:Int,cid:Int): Observable<HttpResult<ArticleResponseBody>>
    }

}