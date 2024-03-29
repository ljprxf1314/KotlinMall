package com.kotlin.user.presenter

import android.net.Network
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.utils.NetWorkUtils
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Administrator on 2019/8/31.
 */
class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService:UserService

    fun register(mobile:String,verifyCode:String,pwd:String){

        if (!checkNetWork()){
            return
        }else{
            mView.showLoading()
        }

        /**
         * 业务逻辑
         */
        //val userService = UserServiceImpl()
        userService.register(mobile,pwd,verifyCode)
                .execute(object:BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if (t)
                        mView.onRegisterResult("注册成功")
                    }
                }, lifecycleProvider)
    }
}