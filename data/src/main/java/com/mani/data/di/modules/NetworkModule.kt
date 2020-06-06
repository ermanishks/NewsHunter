package com.mani.data.di.modules

import android.util.Log
import com.mani.data.BuildConfig
import com.mani.data.networking.HeadLineApis
import com.mani.domain.repositories.PrefsRepo
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *
 */

@Module
class
NetworkModule(private val baseUrl: String) {
    private val readTimeOut = 30L // in seconds
    private val connectTimeOut = 30L // in seconds
    private  val api_key = "844624b964544c63ab297e5b704263e0"

    @Singleton
    @Provides
    fun provideInterceptors(prefsRepo: PrefsRepo): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptorBody = HttpLoggingInterceptor()
        loggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY
        val headerInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("X-Api-Key", api_key)

                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        }
        interceptors.add(headerInterceptor)
        if (BuildConfig.DEBUG) {
            interceptors.add(loggingInterceptorBody)
        }
        return interceptors
    }


/*    @Singleton
    @Provides
    fun provideErrorConverter(retrofit: Retrofit): Converter<ResponseBody, BasicOKResponse> {
        return retrofit.responseBodyConverter(
            BasicOKResponse::class.java,
            arrayOfNulls<Annotation>(0)
        )
    }*/

    @Singleton
    @Provides
    fun provideRetrofit(
        interceptors: ArrayList<Interceptor>
    ): Retrofit {
        val clientBuilder = OkHttpClient.Builder()
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
        if (interceptors.isNotEmpty()) {
            interceptors.forEach { interceptor ->
                clientBuilder.addInterceptor(interceptor)
            }
        }
        return Retrofit.Builder()
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    /**
     * Provide Retrofit API's service from here
     */
    @Singleton
    @Provides
    fun provideTopHeadlineApis(retrofit: Retrofit): HeadLineApis {
        return retrofit.create(HeadLineApis::class.java)
    }
}