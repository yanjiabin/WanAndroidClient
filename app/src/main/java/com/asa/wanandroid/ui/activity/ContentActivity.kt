package com.asa.wanandroid.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.asa.common.constants.Constant
import com.asa.wanandroid.R
import com.asa.wanandroid.base.BaseMvpActivity
import com.asa.wanandroid.base.BaseMvpSwipeBackActivity
import com.asa.wanandroid.event.RefreshHomeEvent
import com.asa.wanandroid.ext.showToast
import com.asa.wanandroid.mvp.contract.ContentContract
import com.asa.wanandroid.mvp.presenter.ContentPresenter
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * create By：anderson
 * on 2021/7/25
 * desc:
 */
class ContentActivity:BaseMvpSwipeBackActivity<ContentContract.View,ContentContract.Presenter>(),ContentContract.View {
    private var shareTitle: String = ""
    private var shareUrl: String = ""
    private var shareId: Int = -1

    companion object{
        fun start(context: Context?,id:Int,title:String,url:String, bundle:Bundle?=null){
            Intent(context,ContentActivity::class.java).apply {
                putExtra(Constant.CONTENT_ID_KEY,id)
                putExtra(Constant.CONTENT_TITLE_KEY,title)
                putExtra(Constant.CONTENT_URL_KEY,url)
                context?.startActivity(this)
            }
        }
    }
    override fun createPresenter(): ContentContract.Presenter {
        return ContentPresenter()
    }

    override fun initView() {
        super.initView()

        intent?.apply {
            shareId = getIntExtra(Constant.CONTENT_ID_KEY,-1)
            shareTitle = getStringExtra(Constant.CONTENT_TITLE_KEY)
            shareUrl = getStringExtra(Constant.CONTENT_URL_KEY)
        }

        toolbar.run {
            title = ""
            setSupportActionBar(this)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

        tv_title?.run {
            text = getString(R.string.loading)
            visibility = View.VISIBLE
            postDelayed({
                tv_title.isSelected = true
            }, 2000)
        }

        initWebView()


    }

    private fun initWebView() {
    }

    override fun start() {

    }

    override fun initData() {

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_content
    }


    override fun showCollectSuccess(success: Boolean) {
        if (success) {
            showToast(getString(R.string.collect_success))
            EventBus.getDefault().post(RefreshHomeEvent(true))
        }
    }

    override fun showCancelCollectSuccess(success: Boolean) {
        if (success) {
            showToast(getString(R.string.cancel_collect_success))
            EventBus.getDefault().post(RefreshHomeEvent(true))
        }
    }
}