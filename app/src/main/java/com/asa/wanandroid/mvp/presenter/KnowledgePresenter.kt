package com.asa.wanandroid.mvp.presenter

import com.asa.wanandroid.ext.ss
import com.asa.wanandroid.mvp.contract.KnowledgeContract
import com.asa.wanandroid.mvp.model.KnowledgeModel

/**
 * create By：anderson
 * on 2021/9/7
 * desc:
 */
class KnowledgePresenter:CommonPresenter<KnowledgeContract.Model,KnowledgeContract.View>(),KnowledgeContract.Presenter {
    override fun createModel(): KnowledgeContract.Model? {
        return KnowledgeModel()
    }

    override fun requestKnowledgeList(page: Int, cid: Int) {
            mModel?.requestKnowledgeList(page,cid)?.ss(mModel,mView){
                mView?.setKnowledgeList(it.data)
            }
    }

}