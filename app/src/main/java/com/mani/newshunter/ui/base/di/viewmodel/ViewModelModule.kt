package com.mani.newshunter.ui.base.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mani.newshunter.features.main.MainViewModel
import com.seera.lar.ops.ui.base.di.viewmodel.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Manish Kumar
 */

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    /**
     * Bind all the view models here
     */


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindsMainViewModel(homeViewModel: MainViewModel): ViewModel



}