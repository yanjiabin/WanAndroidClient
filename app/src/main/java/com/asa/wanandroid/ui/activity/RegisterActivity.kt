package com.asa.wanandroid.ui.activity

import com.asa.wanandroid.R
import com.asa.wanandroid.base.BaseMvpActivity
import com.asa.wanandroid.mvp.contract.RegisterContract
import com.asa.wanandroid.mvp.model.bean.LoginData
import com.asa.wanandroid.mvp.presenter.RegisterPresenter

/**
 * create By：anderson
 * on 2021/7/11
 * desc:
 */
class RegisterActivity:BaseMvpActivity<RegisterContract.View,RegisterContract.Presenter>(),RegisterContract.View {
    override fun createPresenter(): RegisterContract.Presenter {
        return RegisterPresenter()
    }

    override fun start() {

    }

    override fun initData() {

    }

    override fun getLayoutRes(): Int {
       return R.layout.activity_register
    }

    override fun registerSuccess(data: LoginData) {

    }

    override fun registerFail() {

    }
}