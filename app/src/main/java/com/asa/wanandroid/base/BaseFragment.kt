package com.asa.wanandroid.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.asa.wanandroid.ui.view.MultipleStatusView
import org.greenrobot.eventbus.EventBus

abstract class BaseFragment : Fragment() {


    /**
     *  是否加载过数据
     */
    private var hasLoadData = false

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare  = false

    protected var  mLayoutStatusView:MultipleStatusView?=null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(attachlayoutRes(), null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (userEventBus()){
            EventBus.getDefault().register(this)
        }
        isViewPrepare = true
        initView(view)
        lazyLoadDataIfPrepare()
    }

    private fun lazyLoadDataIfPrepare(){
        Log.e("日志", "lazyLoadDataIfPrepare: ")
        if (userVisibleHint && isViewPrepare && !hasLoadData){
            lazyLoad()
            hasLoadData = true
        }
    }

    open fun userEventBus():Boolean = true


    override fun onDestroy() {
        super.onDestroy()
        if (userEventBus()){
            EventBus.getDefault().unregister(this)
        }
    }

    @LayoutRes
    abstract fun attachlayoutRes(): Int


    abstract fun initView(view:View)


    abstract fun lazyLoad()

}