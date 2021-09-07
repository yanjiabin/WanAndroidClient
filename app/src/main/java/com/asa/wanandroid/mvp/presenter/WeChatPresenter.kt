package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.mvp.contract.WeChatContract
import com.asa.wanandroid.mvp.model.WeChatModel

class WeChatPresenter:BasePresenter<WeChatContract.Model,WeChatContract.View>(),WeChatContract.Presenter {


    override fun createModel(): WeChatContract.Model? {
        return WeChatModel()
    }

    override fun getWXChapters() {
        mModel?.getWXChapters()?.ss(mModel,mView){
            mView?.showWXChapters(it.data)
        }
    }
}