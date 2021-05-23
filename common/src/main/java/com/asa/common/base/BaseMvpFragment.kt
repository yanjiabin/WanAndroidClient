package com.asa.common.base

abstract class BaseMvpFragment<in V: IView,P :IPresenter<V>>:BaseFragment(),IView {


}