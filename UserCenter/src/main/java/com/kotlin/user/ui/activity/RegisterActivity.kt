package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.base.common.AppManager
import com.kotlin.base.ext.enable
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast


class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    private var pressTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //实例化Presenter
        //mPresenter = RegisterPresenter()

        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt, { isBtnEnable() })
        mRegisterBtn.enable(mVerifyCodeEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { isBtnEnable() })

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 注册回调
     */
    override fun onRegisterResult(result: String) {
        toast(result)
        //finish()
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }

            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
            }
        }
    }

    /*
       判断按钮是否可用
    */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

//    override fun onBackPressed() {
//        val time = System.currentTimeMillis();
//        if (time - pressTime > 2000) {
//            toast("再按一次退出")
//            pressTime = time
//        } else {
//            AppManager.instance.finishAllActivity()
//        }
//    }

    //        mRegisterBtn.setOnClickListener {
    //1.
    //            startActivity(intentFor<TestActivity>("id" to 5))
    //2
//            startActivity<TestActivity>("id" to 10)
    //3
//            val intent = Intent()
//            intent.setClass(this, TestActivity::class.java)
//            intent.putExtra("id",15)
//            startActivity(intent)
    //toast("注册")
//        }

}
