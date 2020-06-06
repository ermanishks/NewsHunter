package com.mani.newshunter.ui.base.app

import com.mani.newshunter.ui.base.di.AppComponent
import dagger.android.support.DaggerApplication

/**
 * Created by Manish Kumar
 */
abstract class BaseApplication : DaggerApplication() {

    abstract val appComponent: AppComponent

    override fun applicationInjector() = appComponent
}