package com.mani.newshunter.ui.base.di.modules


import com.mani.newshunter.features.main.MainActivity
import com.mani.newshunter.ui.base.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Manish Kumar
 */

@Module
internal abstract class ActivityModule {


    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @ActivityScope
    abstract fun homeActivity(): MainActivity

}