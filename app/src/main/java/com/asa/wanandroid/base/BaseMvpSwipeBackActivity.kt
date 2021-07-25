package com.asa.wanandroid.base

import android.os.Bundle
import com.cxz.swipelibrary.*

/**
 * create By：anderson
 * on 2021/7/25
 * desc:
 */
abstract class BaseMvpSwipeBackActivity<in V:IView,P:IPresenter<V>>:BaseMvpActivity<V,P>(),SwipeBackActivityBase {

    private lateinit var mHelper : SwipeBackActivityHelper

    open fun enableSwipeBack():Boolean = true

    private fun initSwipeBack(){
        setSwipeBackEnable(enableSwipeBack())
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHelper = SwipeBackActivityHelper(this)
        mHelper.onActivityCreate()
        initSwipeBack()
    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mHelper.onPostCreate()
    }

    override fun getSwipeBackLayout(): SwipeBackLayout {
        return mHelper.swipeBackLayout
    }

    override fun setSwipeBackEnable(enable: Boolean) {
        swipeBackLayout.setEnableGesture(enable)
    }

    override fun scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this)
        swipeBackLayout.scrollToFinishActivity()
    }
}