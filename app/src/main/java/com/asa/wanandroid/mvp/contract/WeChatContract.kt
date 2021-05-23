package com.asa.wanandroid.mvp.contract
import com.asa.common.base.IModel
import com.asa.common.base.IPresenter
import com.asa.common.base.IView
import com.asa.wanandroid.mvp.model.HttpResult
import com.asa.wanandroid.mvp.model.WXChapterBean
import io.reactivex.Observable

/**
 * @author chenxz
 * @date 2018/10/28
 * @desc
 */
interface WeChatContract {

    interface View : IView {

        fun scrollToTop()

        fun showWXChapters(chapters: MutableList<WXChapterBean>)

    }

    interface Presenter : IPresenter<View> {
        fun getWXChapters()
    }

    interface Model : IModel {
        fun getWXChapters(): Observable<HttpResult<MutableList<WXChapterBean>>>
    }

}