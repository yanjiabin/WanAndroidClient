package com.asa.wanandroid.mvp.presenter

import android.util.Log
import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.mvp.contract.SquareContract
import com.asa.wanandroid.mvp.model.SquareModel

class SquaretPresenter:CommonPresenter<SquareContract.Model,SquareContract.View>(),SquareContract.Presenter {

    override fun createModel(): SquareContract.Model? {
        return SquareModel()
    }

    override fun getSquareList(page: Int) {
        Log.e("日志", "getSquareList: ")
        mModel?.getSquareList(page)?.ss(mModel,mView,page == 0){
            mView?.showSquareList(it.data)
        }
    }
}