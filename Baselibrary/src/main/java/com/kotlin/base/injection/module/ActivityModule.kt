package com.kotlin.base.injection.module

import android.app.Activity
import com.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lijipei on 2019/9/9.
 */

@Module
class ActivityModule (private val activity: Activity){

    @ActivityScope
    @Provides
    fun providesActivity(): Activity {
        return activity
    }
}