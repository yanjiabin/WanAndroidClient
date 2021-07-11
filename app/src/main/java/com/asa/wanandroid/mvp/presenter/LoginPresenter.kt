package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.mvp.contract.LoginContract
import com.asa.wanandroid.mvp.model.LoginModel

/**
 * create By：anderson
 * on 2021/7/11
 * desc:
 */
class LoginPresenter:BasePresenter<LoginContract.Model,LoginContract.View>(),LoginContract.Presenter {

    override fun createModel(): LoginContract.Model? {
        return LoginModel()
    }
    override fun loginWanAndroid(userName: String, password: String) {
        mModel?.loginWanAndroid(userName,password)?.ss(mModel,mView){
            mView?.loginSuccess(it.data)
        }
    }


}