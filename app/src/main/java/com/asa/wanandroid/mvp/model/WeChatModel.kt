package com.asa.wanandroid.mvp.model

import com.asa.wanandroid.base.BaseModel
import com.asa.wanandroid.http.RetrofitHelper
import com.asa.wanandroid.mvp.contract.WeChatContract
import com.asa.wanandroid.mvp.model.bean.HttpResult
import com.asa.wanandroid.mvp.model.bean.WXChapterBean
import io.reactivex.Observable

/**
 * create By：anderson
 * on 2021/9/7
 * desc:
 */
class WeChatModel:BaseModel(),WeChatContract.Model {

    override fun getWXChapters(): Observable<HttpResult<MutableList<WXChapterBean>>> {
        return RetrofitHelper.serviceApi.getWXChapters()
    }


}