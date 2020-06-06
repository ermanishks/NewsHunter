package com.mani.newshunter

import com.mani.data.di.modules.NetworkModule
import com.mani.newshunter.ui.base.app.BaseApplication
import com.mani.newshunter.ui.base.di.AppComponent
import com.mani.newshunter.ui.base.di.DaggerAppComponent

/**
 * Created by Manish Kumar
 */
 class NewsHunterApplication:BaseApplication() {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .network(NetworkModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}