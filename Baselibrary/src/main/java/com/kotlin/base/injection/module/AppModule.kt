package com.kotlin.base.injection.module

import android.app.Activity
import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lijipei on 2019/9/9.
 */
@Module
class AppModule(private val context:BaseApplication) {

    @Singleton
    @Provides
    fun provideContext():Context{
        return context
    }
}