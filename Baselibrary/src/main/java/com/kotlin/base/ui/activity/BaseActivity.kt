package com.kotlin.base.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.base.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * Created by Administrator on 2019/8/31.
 *
 */
open class BaseActivity : RxAppCompatActivity(){
    //如果想继承某个类,这个类必须是open的

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}