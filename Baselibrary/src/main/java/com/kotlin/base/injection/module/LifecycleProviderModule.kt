package com.kotlin.base.injection.module

import android.app.Activity
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by lijipei on 2019/9/17.
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*>{
        return this.lifecycleProvider;
    }

}