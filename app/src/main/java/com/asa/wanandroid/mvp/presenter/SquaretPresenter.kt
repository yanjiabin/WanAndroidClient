package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.mvp.contract.SquareContract

class SquaretPresenter:CommonPresenter<SquareContract.Model,SquareContract.View>(),SquareContract.Presenter {

    override fun getSquareList(page: Int) {

    }
}