package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.base.BaseModel
import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.MainContract
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.UserInfoBody
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/6/5
 * desc:
 */
class MainModel : BaseModel(), MainContract.Model {

    override fun logout(): Observable<HttpResult<Any>> {
        return RetrofitHelper.serviceApi.logout()
    }


    override fun getUserInfo(): Observable<HttpResult<UserInfoBody>> {
        return RetrofitHelper.serviceApi.getUserInfo()
    }

}