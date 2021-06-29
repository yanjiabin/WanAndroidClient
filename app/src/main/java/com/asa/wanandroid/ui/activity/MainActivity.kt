package com.asa.wanandroid.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.asa.wanandroid.base.BaseMvpActivity
import com.asa.wanandroid.R
import com.asa.wanandroid.event.RefreshHomeEvent
import com.asa.wanandroid.mvp.contract.MainContract
import com.asa.wanandroid.mvp.model.bean.UserInfoBody
import com.asa.wanandroid.mvp.presenter.MainPresenter
import com.asa.wanandroid.ui.fragment.HomeFragment
import com.asa.wanandroid.ui.fragment.SquareFragment
import com.asa.wanandroid.ui.fragment.WeChatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseMvpActivity<MainContract.View,MainContract.Presenter>(),MainContract.View {

    override fun createPresenter(): MainContract.Presenter = MainPresenter()

    companion object{
        val FRAGMENT_HOME =0x001
        val FRAGMENT_SQUARE =0x002
        val FRAGMENT_WECHAT =0x003
        val FRAGMENT_SYSTEM =0x004

    }

    private var mHomeFragment:HomeFragment?=null
    private var mSquareFragment:SquareFragment?=null
    private var mWechatFragment:WeChatFragment?=null

    private var index = FRAGMENT_HOME

    override fun initView() {
        super.initView()
        bottom_navigation.run {
            // 以前使用 BottomNavigationViewHelper.disableShiftMode(this) 方法来设置底部图标和字体都显示并去掉点击动画
            // 升级到 28.0.0 之后，官方重构了 BottomNavigationView ，目前可以使用 labelVisibilityMode = 1 来替代
            // BottomNavigationViewHelper.disableShiftMode(this)
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }

        showFragment(index)

    }
    override fun start() {

    }

    override fun initData() {

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun showLogoutSuccess(success: Boolean) {

    }

    override fun showUserInfo(bean: UserInfoBody) {

    }


    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.action_home -> {
                    showFragment(FRAGMENT_HOME)
                    true
                }
                R.id.action_square -> {
                    showFragment(FRAGMENT_SQUARE)
                    true
                }
//                R.id.action_system -> {
//                    showFragment(FRAGMENT_SYSTEM)
//                    true
//                }
//                R.id.action_project -> {
//                    showFragment(FRAGMENT_PROJECT)
//                    true
//                }
                R.id.action_wechat -> {
                    showFragment(FRAGMENT_WECHAT)
                    true
                }
                else -> {
                    false
                }

            }
        }



    private fun showFragment(index:Int){
        val beginTransaction = supportFragmentManager.beginTransaction()
        hideFragment(beginTransaction)
        this.index = index
        when (index) {
            FRAGMENT_HOME -> {
                if (mHomeFragment == null){
                    mHomeFragment = HomeFragment()
                    beginTransaction.add(R.id.container,mHomeFragment!!,"home")
                } else{
                    beginTransaction.show(mHomeFragment!!)
                }
            }
            FRAGMENT_SQUARE->{
                if (mSquareFragment == null){
                    mSquareFragment = SquareFragment()
                    beginTransaction.add(R.id.container,mSquareFragment!!,"square")
                } else{
                    beginTransaction.show(mSquareFragment!!)
                }
            }
            FRAGMENT_WECHAT->{
                if (mWechatFragment == null){
                    mWechatFragment = WeChatFragment()
                    beginTransaction.add(R.id.container,mWechatFragment!!,"wechat")
                }else{
                    beginTransaction.show(mWechatFragment!!)
                }
            }
            else -> {
            }
        }

        beginTransaction.commit()
    }

    private fun hideFragment(beginTransaction: FragmentTransaction) {
        mHomeFragment?.let { beginTransaction.hide(it) }
        mSquareFragment?.let { beginTransaction.hide(it) }
        mWechatFragment?.let { beginTransaction.hide(it) }
    }

    override fun userEvent(): Boolean {
        return false
    }
}