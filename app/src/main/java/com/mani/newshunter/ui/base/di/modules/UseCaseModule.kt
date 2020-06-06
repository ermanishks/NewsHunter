package com.mani.newshunter.ui.base.di.modules

import com.mani.domain.repositories.TopHeadlineRepo
import com.mani.domain.usecase.FetchTopHeadlineUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Manish
 */

@Module
class UseCaseModule {


    /**
     * Provide all the use cases from here
     */
    @Provides
    fun provideHeadlineUseCase(headlineRepo: TopHeadlineRepo): FetchTopHeadlineUseCase{
        return FetchTopHeadlineUseCase(headlineRepo)
    }
}