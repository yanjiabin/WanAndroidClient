package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.mvp.contract.HomeContract

class HomePresenter:CommonPresenter<HomeContract.Model,HomeContract.View>(),HomeContract.Presenter {

    override fun requestBanner() {

    }

    override fun requestHomeData() {
    }

    override fun requestArticles(num: Int) {

    }
}