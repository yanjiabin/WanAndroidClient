package com.asa.wanandroid.ui.activity

import android.os.Bundle
import com.asa.wanandroid.base.BaseMvpActivity
import com.asa.wanandroid.R
import com.asa.wanandroid.mvp.contract.MainContract
import com.asa.wanandroid.mvp.model.bean.UserInfoBody
import com.asa.wanandroid.mvp.presenter.MainPresenter

class MainActivity : BaseMvpActivity<MainContract.View,MainContract.Presenter>(),MainContract.View {

    override fun createPresenter(): MainContract.Presenter = MainPresenter()

    override fun start() {

    }

    override fun initData() {

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun showLogoutSuccess(success: Boolean) {

    }

    override fun showUserInfo(bean: UserInfoBody) {

    }


}