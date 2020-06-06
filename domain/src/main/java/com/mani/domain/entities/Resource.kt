package com.mani.domain.entities

import com.mani.domain.execptions.ApiError

/**
 * Created by Manish Kumar
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?, val error: ApiError?) {

    fun isSuccessful(): Boolean{
        return status == Status.SUCCESS
    }

    companion object {

        fun <T> success(data: T?, message:String?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                message,
                null
            )
        }

        fun <T> error(error: ApiError?): Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                error?.status ?: "",
                error
            )
        }

        fun <T> loading(data: T?): Resource<T>{
            return Resource(
                Status.LOADING,
                data,
                null,
                null
            )
        }
    }
}