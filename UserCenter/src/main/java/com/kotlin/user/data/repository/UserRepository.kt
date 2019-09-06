package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocol.RegisterReq
import com.kotlin.user.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * Created by lijipei on 2019/9/5.
 */
class UserRepository @Inject constructor(){

    fun register(mobile:String,pwd:String,verifyCode:String)
            :Observable<BaseResp<String>>{

        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile,pwd,verifyCode))
    }
}