package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.base.IModel
import com.asa.wanandroid.base.IPresenter
import com.asa.wanandroid.base.IView
import com.asa.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
interface CommonContract {

    interface View :IView{
        fun showCollectSuccess(success:Boolean)

        fun showCancelCollectSuccess(success: Boolean)
    }

    interface Presenter<in V:IView>:IPresenter<V>{

        fun addCollectArticle(id:Int)

        fun cancelCollectArticle(id:Int)
    }



    interface Model:IModel{

        fun addCollectArticle(id: Int): Observable<HttpResult<Any>>

        fun cancelCollectArticle(id: Int): Observable<HttpResult<Any>>

    }

}