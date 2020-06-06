package com.mani.data.di.modules

import com.mani.data.networking.HeadLineApis
import com.mani.data.repositories.TopHeadlineRepoImpl
import com.mani.domain.repositories.TopHeadlineRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Manish
 */

@Module
class RepoModule {
    /**
     * Provide all the Repositories from here
     */
    @Singleton
    @Provides
    fun provideTopHeadlineRepo(apis: HeadLineApis): TopHeadlineRepo{
        return TopHeadlineRepoImpl(apis)
    }




}