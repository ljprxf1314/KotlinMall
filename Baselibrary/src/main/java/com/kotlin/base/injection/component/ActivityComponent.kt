package com.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by lijipei on 2019/9/9.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {

    fun activity():Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}