package com.kotlin.user.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.base.ui.activity.BaseMvpActivity

import com.kotlin.user.R
import com.kotlin.user.R.id.mRegisterBtn
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //实例化Presenter
        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        mRegisterBtn.setOnClickListener {

            mPresenter.register("","","")

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
        }
    }
}