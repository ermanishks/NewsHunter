package com.mani.domain.repositories

import com.mani.domain.entities.Resource
import com.mani.domain.entities.model.TopHeadlineVO


/**
 * Created by Manish Kumar
 */
interface TopHeadlineRepo {

    suspend fun fetchTopHeadlines(country: String = "in"): Resource<TopHeadlineVO>
}