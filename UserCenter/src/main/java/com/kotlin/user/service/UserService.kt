package com.kotlin.user.service

import rx.Observable
import java.util.*

/**
 * Created by Administrator on 2019/9/1.
 */
interface UserService {
    fun register(mobile:String,verifyCode:String,pwd:String):Observable<Boolean>
}