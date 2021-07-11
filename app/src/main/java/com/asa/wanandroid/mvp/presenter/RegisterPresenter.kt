package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.mvp.contract.RegisterContract

/**
 * create By：anderson
 * on 2021/7/11
 * desc:
 */
class RegisterPresenter:BasePresenter<RegisterContract.Model,RegisterContract.View>(),RegisterContract.Presenter{

    override fun registerWanAndroid(userName: String, password: String) {

    }
}