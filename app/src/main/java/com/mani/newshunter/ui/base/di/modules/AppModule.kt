package com.mani.newshunter.ui.base.di.modules

import android.app.Application
import android.content.Context
import com.mani.data.di.modules.NetworkModule
import com.mani.newshunter.ui.base.di.viewmodel.ViewModelModule
import com.mani.data.di.modules.RepoModule
import com.mani.data.di.modules.SharedPrefsModule

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */

@Module(
    includes = [
        (NetworkModule::class),
        (RepoModule::class),
        (UseCaseModule::class),
        (ViewModelModule::class),
        (SharedPrefsModule::class)
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}