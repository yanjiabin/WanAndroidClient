package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.mvp.contract.ContentContract
import com.asa.wanandroid.mvp.model.ContentModel

/**
 * create By：anderson
 * on 2021/7/25
 * desc:
 */
class ContentPresenter:CommonPresenter<ContentContract.Model,ContentContract.View>(),ContentContract.Presenter {


    override fun createModel(): ContentContract.Model? {
        return ContentModel()

    }

}