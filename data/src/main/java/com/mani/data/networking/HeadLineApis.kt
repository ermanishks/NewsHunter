package com.mani.data.networking

import com.mani.domain.entities.model.TopHeadlineVO
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created by Manish Kumar
 */
@Singleton
interface HeadLineApis {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") countryCode: String): TopHeadlineVO
}