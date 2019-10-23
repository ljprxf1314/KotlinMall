package com.kotlin.goods.ui.activity

import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.goods.injection.component.DaggerGoodsComponent
import com.kotlin.goods.injection.module.GoodsModule
import com.kotlin.goods.presenter.GoodsListPresenter

/**
 * Created by lijipei on 2019/10/20.
 */
class GoodsActivity: BaseMvpActivity<GoodsListPresenter>() {



    override fun injectComponent() {
//        DaggerGoodsComponent.builder().activityComponent(mActivityComponent).
//                goodsModule(GoodsModule()).build().inject(this)
    }

}