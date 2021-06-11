package com.asa.wanandroid.ui.fragment

import android.view.View
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.mvp.contract.SquareContract
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class SquareFragment:BaseMvpFragment<SquareContract.View,SquareContract.Presenter>(),SquareContract.View {


    companion object{
        fun getInstance():SquareFragment = SquareFragment()
    }
    override fun attachlayoutRes(): Int= R.layout.fragment_square

    override fun initView(view: View) {
        
    }

    override fun lazyLoad() {
        
    }

    override fun scrollToTop() {
        
    }

    override fun showSquareList(body: ArticleResponseBody) {
        
    }

    override fun showCollectSuccess(success: Boolean) {
        
    }

    override fun showCancelCollectSuccess(success: Boolean) {
        
    }
}