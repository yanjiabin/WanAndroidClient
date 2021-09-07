package com.asa.wanandroid.ui.fragment

import android.os.Bundle
import com.asa.common.constants.Constant
import com.asa.wanandroid.R
import com.asa.wanandroid.base.BaseMvpFragment
import com.asa.wanandroid.mvp.contract.KnowledgeContract
import com.asa.wanandroid.mvp.model.bean.ArticleResponseBody
import com.asa.wanandroid.mvp.presenter.KnowledgePresenter

/**
 * create By：anderson
 * on 2021/9/7
 * desc:
 */
class KnowledgeFragment:BaseMvpFragment<KnowledgeContract.View,KnowledgeContract.Presenter>(),KnowledgeContract.View {

    companion object{
        fun getInstance(cid:Int):KnowledgeFragment{
            val instance = KnowledgeFragment()
            instance.arguments = Bundle().apply {
                putInt(Constant.CONTENT_CID_KEY,cid)
            }
            return instance
        }
    }

    override fun createPresenter(): KnowledgeContract.Presenter {
        return KnowledgePresenter()
    }

    override fun attachlayoutRes(): Int  = R.layout.fragment_refresh_layout

    override fun lazyLoad() {
    }

    override fun scrollToTop() {

    }

    override fun setKnowledgeList(articles: ArticleResponseBody) {

    }

    override fun showCollectSuccess(success: Boolean) {

    }

    override fun showCancelCollectSuccess(success: Boolean) {

    }

    override fun userEventBus(): Boolean {
        return false
    }
}