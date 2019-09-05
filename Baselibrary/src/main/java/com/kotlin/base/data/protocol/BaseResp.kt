package com.kotlin.base.data.protocol

/**
 * Created by lijipei on 2019/9/5.
 */
class BaseResp<out T>(val status:Int, val message:String, val data:T)