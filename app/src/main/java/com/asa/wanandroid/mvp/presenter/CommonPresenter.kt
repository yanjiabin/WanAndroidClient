package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.mvp.contract.CommonContract
import com.asa.wanandroid.mvp.contract.HomeContract

open class CommonPresenter<M:CommonContract.Model,V:CommonContract.View>:BasePresenter<M,V>(),CommonContract.Presenter<V> {

    override fun addCollectArticle(id: Int) {
        mModel?.addCollectArticle(id)?.ss(mModel, mView) {
            mView?.showCollectSuccess(true)
        }
    }

    override fun cancelCollectArticle(id: Int) {
        mModel?.cancelCollectArticle(id)?.ss(mModel, mView) {
            mView?.showCancelCollectSuccess(true)
        }
    }


}