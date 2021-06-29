package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.mvp.contract.WeChatContract

class WeChatPresenter:BasePresenter<WeChatContract.Model,WeChatContract.View>(),WeChatContract.Presenter {


    override fun getWXChapters() {

    }
}