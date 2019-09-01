package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 * Created by Administrator on 2019/8/31.
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView : T
}