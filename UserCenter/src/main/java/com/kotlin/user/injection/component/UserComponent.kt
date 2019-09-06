package com.kotlin.user.injection.component

import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by lijipei on 2019/9/6.
 */
@Component(modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity:RegisterActivity)
}