package com.lbg.technicaltest.network

import com.lbg.technicaltest.model.error.ErrorApiResponse

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val errorData: ErrorApiResponse? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null, errorData: ErrorApiResponse? = null) :
        Resource<T>(data, message, errorData)

    class Loading<T>(data: T? = null) : Resource<T>(data)
}