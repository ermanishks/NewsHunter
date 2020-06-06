package com.mani.newshunter.ui.base.di

import android.app.Application
import com.mani.data.di.modules.NetworkModule
import com.mani.newshunter.ui.base.di.modules.ActivityModule
import com.mani.newshunter.ui.base.di.modules.AppModule
import com.mani.newshunter.ui.base.di.modules.ServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (ActivityModule::class),
    (ServiceModule::class)
])

interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun network(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}