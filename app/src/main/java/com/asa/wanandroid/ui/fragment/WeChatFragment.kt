package com.asa.wanandroid.ui.fragment

import android.view.View
import com.asa.common.base.BaseMvpFragment
import com.asa.wanandroid.R
import com.asa.wanandroid.mvp.contract.WeChatContract
import com.asa.wanandroid.mvp.model.WXChapterBean

/**
 * create By：anderson
 * on 2021/5/22
 * desc:
 */
class WeChatFragment:BaseMvpFragment<WeChatContract.View,WeChatContract.Presenter>(),WeChatContract.View {

    companion object{
        fun getInstance():WeChatFragment= WeChatFragment()
    }
    override fun attachlayoutRes(): Int  = R.layout.fragment_wechat

    override fun initView(view: View) {
        
    }

    override fun lazyLoad() {
        
    }

    override fun scrollToTop() {
        
    }

    override fun showWXChapters(chapters: MutableList<WXChapterBean>) {
        
    }
}