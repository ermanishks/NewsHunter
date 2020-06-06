package com.mani.data.di.modules.prefs

import android.content.Context
import com.mani.domain.repositories.PrefsRepo
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */
@Singleton
class SharedPrefs(private val ctx: Context) : PrefsRepo {

}