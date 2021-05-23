package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.mvp.model.ArticleResponseBody
import com.asa.wanandroid.mvp.model.HttpResult
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
interface SquareContract {

    interface View : CommonContract.View {
        fun scrollToTop()
        fun showSquareList(body: ArticleResponseBody)
    }

    interface Presenter : CommonContract.Presenter<View> {
        fun getSquareList(page: Int)
    }

    interface Model : CommonContract.Model {
        fun getSquareList(page: Int): Observable<HttpResult<ArticleResponseBody>>
    }
}