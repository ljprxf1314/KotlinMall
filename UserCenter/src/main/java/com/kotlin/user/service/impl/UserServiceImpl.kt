package com.kotlin.user.service.impl

import com.kotlin.user.service.UserService
import rx.Observable

/**
 * Created by Administrator on 2019/9/1.
 */
class UserServiceImpl: UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}