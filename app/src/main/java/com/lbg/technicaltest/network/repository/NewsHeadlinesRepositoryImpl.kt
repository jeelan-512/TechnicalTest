package com.lbg.technicaltest.network.repository

import android.util.Log
import com.lbg.technicaltest.model.NewsHeadlinesResponse
import com.lbg.technicaltest.network.ApiService
import com.lbg.technicaltest.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsHeadlinesRepositoryImpl (private val apiService: ApiService) : NewsHeadlinesRepository {
    override fun getNewsHeadlinesData(
        sources: String?,
        apiKey: String?
    ): Flow<Resource<NewsHeadlinesResponse>> = flow {
        try {
            emit(
                Resource.Success(
                    apiService.getNewsHeadlines(sources, apiKey)
                )
            )
        } catch (exception: Exception) {
            Log.e("APIException", "Exception : $exception")
        }
    }
}