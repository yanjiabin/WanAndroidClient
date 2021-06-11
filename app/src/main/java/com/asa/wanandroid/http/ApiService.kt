package com.asa.wanandroid.http

import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.UserInfoBody
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {


    /**
     * 退出登录
     * http://www.wanandroid.com/user/logout/json
     */
    @GET("user/logout/json")
    fun logout(): Observable<HttpResult<Any>>


    /**
     * 获取个人积分，需要登录后访问
     * https://www.wanandroid.com/lg/coin/userinfo/json
     */
    @GET("/lg/coin/userinfo/json")
    fun getUserInfo(): Observable<HttpResult<UserInfoBody>>
}