package com.mani.data.networking

import com.mani.domain.entities.Resource
import com.mani.domain.entities.model.TopHeadlineVO
import com.mani.domain.execptions.ApiError

/**
 * Created by Manish Kumar
 */


fun handleHeadlineResponse(response: TopHeadlineVO):Resource<TopHeadlineVO>{
    return when (response.status) {
        "ok" ->{
            try {
                Resource.success(response,response.status)
            }catch (e: Exception) {
                e.printStackTrace()
                Resource.error<TopHeadlineVO>(ApiError(e.message))
            }
        }
        "error"->{Resource.error(ApiError("something went wrong"))}
        else -> Resource.error(ApiError(response.status))
    }
}
