package com.kotlin.base.presenter.view

/**
 * Created by Administrator on 2019/8/31.
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(str:String)
}