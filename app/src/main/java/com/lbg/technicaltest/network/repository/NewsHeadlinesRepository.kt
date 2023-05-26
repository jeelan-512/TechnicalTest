package com.lbg.technicaltest.network.repository

import com.lbg.technicaltest.model.NewsHeadlinesResponse
import com.lbg.technicaltest.network.Resource
import kotlinx.coroutines.flow.Flow

interface NewsHeadlinesRepository {
     fun getNewsHeadlinesData(
        sources: String?,
        api: String?
    ): Flow<Resource<NewsHeadlinesResponse>>
}