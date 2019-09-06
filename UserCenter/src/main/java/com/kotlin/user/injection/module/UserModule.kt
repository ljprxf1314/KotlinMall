package com.kotlin.user.injection.module

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by lijipei on 2019/9/5.
 */
@Module
class UserModule {

    @Provides
    fun providesUserService(services:UserServiceImpl):UserService{
        return services
    }
}