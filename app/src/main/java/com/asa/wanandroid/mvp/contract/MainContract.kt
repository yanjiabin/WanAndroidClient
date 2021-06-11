package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.base.IModel
import com.asa.wanandroid.base.IPresenter
import com.asa.wanandroid.base.IView
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.UserInfoBody
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/6/5
 * desc:
 */
interface MainContract {

    interface View:IView{
        fun showLogoutSuccess(success: Boolean)
        fun showUserInfo(bean: UserInfoBody)
    }

    interface Presenter:IPresenter<View>{
        fun logout()
        fun getUserInfo()

    }

    interface Model:IModel{
        fun logout(): Observable<HttpResult<Any>>
        fun getUserInfo(): Observable<HttpResult<UserInfoBody>>
    }

}