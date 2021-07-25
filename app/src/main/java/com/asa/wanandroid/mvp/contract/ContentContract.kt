package com.asa.wanandroid.mvp.contract

import com.asa.wanandroid.base.IModel
import com.asa.wanandroid.base.IPresenter
import com.asa.wanandroid.base.IView

/**
 * create By：anderson
 * on 2021/7/25
 * desc:
 */
interface ContentContract {

    interface View:CommonContract.View{

    }

    interface Presenter:IPresenter<View>{

    }

    interface Model:CommonContract.Model{

    }

}