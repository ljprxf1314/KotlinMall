package com.kotlin.user.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.base.common.AppManager
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.base.widgets.VerifyButton

import com.kotlin.user.R
import com.kotlin.user.R.id.mRegisterBtn
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    private var pressTime :Long = 0

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
            toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //实例化Presenter
        //mPresenter = RegisterPresenter()

        mRegisterBtn.onClick {
            mPresenter.register(mMobileEt.text.toString(),
                    mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
        }

        mGetVerifyCodeBtn.onClick {
            mGetVerifyCodeBtn.requestSendVerifyNumber()
        }

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

    override fun onBackPressed() {
        val time = System.currentTimeMillis();
        if (time - pressTime > 2000){
            toast("再按一次退出")
            pressTime = time
        }else{
            AppManager.instance.finishAllActivity()
        }
    }

}
