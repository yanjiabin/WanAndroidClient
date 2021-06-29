package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.mvp.contract.CommonContract
import com.asa.wanandroid.mvp.contract.HomeContract

open class CommonPresenter<M:CommonContract.Model,V:CommonContract.View>:BasePresenter<M,V>(),CommonContract.Presenter<V> {
    override fun addCollectArticle(id: Int) {

    }

    override fun cancelCollectArticle(id: Int) {
    }


}