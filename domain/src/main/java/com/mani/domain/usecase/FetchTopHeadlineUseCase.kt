package com.mani.domain.usecase

import com.mani.domain.entities.Resource
import com.mani.domain.entities.model.TopHeadlineVO
import com.mani.domain.repositories.TopHeadlineRepo

/**
 * Created by Manish Kumar
 */
class FetchTopHeadlineUseCase(private val headlineRepo: TopHeadlineRepo) {

    suspend fun execute(countryCode:String): Resource<TopHeadlineVO> {
        return headlineRepo.fetchTopHeadlines(countryCode)
    }
}