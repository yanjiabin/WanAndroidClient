package com.asa.wanandroid.mvp.contract
import com.asa.wanandroid.base.IModel
import com.asa.wanandroid.base.IPresenter
import com.asa.wanandroid.base.IView
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.WXChapterBean
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