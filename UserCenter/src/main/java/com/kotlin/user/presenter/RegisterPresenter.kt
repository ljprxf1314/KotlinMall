package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.impl.UserServiceImpl
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 2019/8/31.
 */
class RegisterPresenter: BasePresenter<RegisterView>() {

    fun register(mobile:String,verifyCode:String,pwd:String){
        /**
         * 业务逻辑
         */
        val userService = UserServiceImpl()
        userService.register(mobile,verifyCode,pwd)
                .execute(object:BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(true)
                    }
                })
    }
}