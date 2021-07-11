package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.base.BaseModel
import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.LoginContract
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.LoginData
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/7/11
 * desc:
 */
class LoginModel:BaseModel(),LoginContract.Model {
    override fun loginWanAndroid(
        userName: String,
        password: String
    ): Observable<HttpResult<LoginData>> {
        return RetrofitHelper.serviceApi.loginWanAndroid(userName,password)
    }
}