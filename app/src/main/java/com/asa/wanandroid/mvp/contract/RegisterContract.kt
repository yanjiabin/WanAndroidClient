package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.base.IModel
import com.asa.wanandroid.base.IPresenter
import com.asa.wanandroid.base.IView
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.LoginData
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/7/11
 * desc:
 */
interface RegisterContract {


    interface View:IView{
        fun registerSuccess(data:LoginData)
        fun registerFail()
    }

    interface Presenter:IPresenter<View>{
        fun registerWanAndroid(userName: String,password:String)
    }

    interface Model:IModel{
        fun registerWanAndroid(userName: String,password: String):Observable<HttpResult<LoginData>>
    }
}