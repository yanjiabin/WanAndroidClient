package com.asa.wanandroid.base

import com.asa.wanandroid.ext.showToast

abstract class BaseMvpActivity<in V:IView,P:IPresenter<V>>:BaseActivity(),IView {

    var mPresenter:P?=null


    abstract fun createPresenter():P

    override fun initView() {
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
        this.mPresenter = null

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showError(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun showDefaultMsg(msg: String) {
        showToast(msg)
    }

    override fun showMsg(msg: String) {
        showToast(msg)
    }


}