package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.base.BasePresenter
import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.ext.sss
import com.asa.wanandroid.mvp.contract.MainContract
import com.asa.wanandroid.mvp.model.MainModel

/**
 * create By：anderson
 * on 2021/6/5
 * desc:
 */
class MainPresenter:BasePresenter<MainContract.Model,MainContract.View>(), MainContract.Presenter {

    override fun createModel(): MainContract.Model? = MainModel()

    override fun logout() {
        mModel?.logout()?.ss(mModel, mView) {
            mView?.showLogoutSuccess(success = true)
        }
    }

    override fun getUserInfo() {
        mModel?.getUserInfo()?.sss(mView, false, {
            mView?.showUserInfo(it.data)
        }, {})
    }

}