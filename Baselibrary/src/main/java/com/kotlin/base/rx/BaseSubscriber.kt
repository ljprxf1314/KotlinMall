package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber
import java.net.ConnectException

/**
 * Created by Administrator on 2019/9/1.
 */
open class BaseSubscriber<T>(val baseView:BaseView): Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        }else if (e is ConnectException){
            baseView.onError(e.toString())
        }
    }
}