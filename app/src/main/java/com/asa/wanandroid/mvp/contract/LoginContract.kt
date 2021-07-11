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
class LoginContract {


    interface View:IView{
        fun loginSuccess(data:LoginData)

        fun loginFail()
    }


    interface Presenter:IPresenter<View>{
        fun loginWanAndroid(userName:String,password:String)
    }

    interface Model:IModel{
        fun loginWanAndroid(userName: String,password: String): Observable<HttpResult<LoginData>>
    }

}