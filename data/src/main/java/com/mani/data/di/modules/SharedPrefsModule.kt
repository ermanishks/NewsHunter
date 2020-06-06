package com.mani.data.di.modules

import android.content.Context
import com.mani.data.di.modules.prefs.SharedPrefs
import com.mani.domain.repositories.PrefsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Manish .
 */

@Module
class SharedPrefsModule {

    @Singleton
    @Provides
    fun provideSharedPrefs(context: Context): SharedPrefs {
        return SharedPrefs(context)
    }

    @Singleton
    @Provides
    fun providePrefsRepo(context: Context): PrefsRepo {
        return SharedPrefs(context)
    }
}