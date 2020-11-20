package com.example.module_usercenter.activity

import android.content.Context
import android.graphics.Paint
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.BaseMVPActivity
import com.example.common_base.constants.AConstance
import com.example.common_base.constants.AConstance.ACTIVITY_URL_MAIN
import com.example.common_base.constants.AConstance.ACTIVITY_URL_REGISTER
import com.example.common_base.constants.Constants
import com.example.common_base.util.ToastUtil
import com.example.module_usercenter.R
import com.example.module_usercenter.bean.LoginResult
import com.example.module_usercenter.contract.LoginContract
import com.example.module_usercenter.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = AConstance.ACTIVITY_URL_LOGIN)
class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginContract.View, View.OnClickListener {

    override fun onClick(v: View?) {
        when (v) {
            btn_login -> {
                login()
            }
            tv_register -> ARouter.getInstance().build(ACTIVITY_URL_REGISTER).navigation()

            else -> print("none of the above")
        }
    }

    override fun loginSuccess(loginResult: LoginResult) {
        presenter.saveUserNamePwd(
            et_login_username.text.trim().toString(),
            et_login_password.text.trim().toString()
        )
        ARouter.getInstance().build(ACTIVITY_URL_MAIN).navigation()
        finish()
    }

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun createPresenter(): LoginPresenter = LoginPresenter()

    override fun initView() {
    }

    override fun initData() {
        super.initData()
        //设置下划线
        tv_register.paint.flags = Paint.UNDERLINE_TEXT_FLAG
        //拿取以登录过的账号密码显示
        val userName = presenter.readUserNamePwd(Constants.USERNAME)
        val passWord = presenter.readUserNamePwd(Constants.PASSWORD)

        et_login_username.setText(userName)
        et_login_username.setSelection(userName.length)
        et_login_password.setText(passWord)
        et_login_password.setSelection(passWord.length)

        btn_login.setOnClickListener(this)
        tv_register.setOnClickListener(this)

        //密码框右侧的密码可见不可见按钮
        cb_login_pwd_visible.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //可以隐藏/显示文本
                et_login_password.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                //设置光标在文字末尾
                et_login_password.setSelection(et_login_password.text.toString().length)
            } else {
                et_login_password.transformationMethod = PasswordTransformationMethod.getInstance()
                et_login_password.setSelection(et_login_password.text.toString().length)
            }
        }

        et_login_password.setOnEditorActionListener { _, actionId, _ ->
            //监听完成按钮 关闭软键盘 并且开始登录
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val imm =
                    et_login_password.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(et_login_password.windowToken, 0)
                login()
                true
            }
            false
        }
    }

    private fun login() {
        val phone = et_login_username.text.trim().toString()
        val pwd = et_login_password.text.trim().toString()
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showShortToast(this,R.string.please_input_username)
            return
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtil.showShortToast(this,R.string.please_input_password)
            return
        }
        presenter.login(phone, pwd)
    }
}
