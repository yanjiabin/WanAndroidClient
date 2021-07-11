package com.asa.wanandroid.ui.activity

import android.content.Intent
import android.view.View
import com.asa.common.constants.Constant
import com.asa.common.utils.Preference
import com.asa.wanandroid.R
import com.asa.wanandroid.base.BaseMvpActivity
import com.asa.wanandroid.event.LoginEvent
import com.asa.wanandroid.ext.showToast
import com.asa.wanandroid.mvp.contract.LoginContract
import com.asa.wanandroid.mvp.model.bean.LoginData
import com.asa.wanandroid.mvp.presenter.LoginPresenter
import com.asa.wanandroid.utils.DialogUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * create By：anderson
 * on 2021/7/11
 * desc:
 */
class LoginActivity:BaseMvpActivity<LoginContract.View,LoginContract.Presenter>(),LoginContract.View {

    private var isLogin :Boolean by Preference(Constant.LOGIN_KEY,false)
    private var user:String by Preference(Constant.USERNAME_KEY,"")
    private var password:String by Preference(Constant.PASSWORD_KEY,"")
    private var token:String by Preference(Constant.TOKEN_KEY,"")

    private val mDialog by lazy {
        DialogUtil.getWaitDialog(this,getString(R.string.login_ing))
    }


    override fun createPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }

    override fun start() {
        et_username.setText(user)

        toolbar.apply {
            title = "登录"
            setSupportActionBar(this)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

        btn_login.setOnClickListener(onClickListener)
        tv_sign_up.setOnClickListener(onClickListener)
    }

    override fun initData() {

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun loginSuccess(data: LoginData) {
        showToast("登录成功")
        isLogin = true
        user = data.username
        password = data.password
        token = data.token
        EventBus.getDefault().post(LoginEvent(true))
        finish()
    }

    override fun loginFail() {

    }

    private val onClickListener = View.OnClickListener {view->
        when (view.id) {
            R.id.btn_login -> {
                login()
            }
            R.id.tv_sign_up->{

                Intent(this,RegisterActivity::class.java).run {
                    startActivity(this)
                    finish()
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                }
            }
            else -> {
            }
        }


    }

    private fun login() {
        if (validate()){
            mPresenter?.loginWanAndroid(et_username.text.toString(),et_password.text.toString())
        }
    }

    private fun validate(): Boolean {
        var valid = true
        val userNameContent = et_username.text.toString()
        val passwordContent = et_password.text.toString()
        if (userNameContent.isEmpty()){
            et_username.error = "用户名不能为空"
            valid = false
        }
        if (passwordContent.isEmpty()){
            et_password.error = "密码不能为空"
            valid = false
        }
        return valid
    }
}