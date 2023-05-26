package com.lbg.technicaltest.network

import com.lbg.technicaltest.model.NewsHeadlinesResponse
import com.lbg.technicaltest.utils.ParameterConstants
import io.ktor.client.*
import io.ktor.client.request.*

class ApiService (private val client: HttpClient, private val baseURL: String) {

    suspend fun getNewsHeadlines(sources: String?, apiKey: String? = "20e968144e754cbea26e29f1a8324487"): NewsHeadlinesResponse =
        client.get("$baseURL") {
            parameter(ParameterConstants.SOURCES, sources)
            parameter(ParameterConstants.API_KEY, apiKey)
        }
}