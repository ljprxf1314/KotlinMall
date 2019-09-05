package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

/**
 * Created by Administrator on 2019/8/31.
 */
open class BaseMvpActivity<T:BasePresenter<*>> :BaseActivity(),BaseView{

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    @Inject
    lateinit var mPresenter: T

}