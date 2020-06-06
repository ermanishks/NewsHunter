package com.mani.data.repositories

import com.mani.data.networking.HeadLineApis
import com.mani.data.networking.handleHeadlineResponse
import com.mani.domain.entities.Resource
import com.mani.domain.entities.model.TopHeadlineVO
import com.mani.domain.repositories.TopHeadlineRepo

class TopHeadlineRepoImpl(val headLineApis: HeadLineApis) : TopHeadlineRepo {

    override suspend fun fetchTopHeadlines(country: String): Resource<TopHeadlineVO> {
     return handleHeadlineResponse(headLineApis.getTopHeadlines(country))
    }
}