package com.lbg.technicaltest.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.lbg.technicaltest.model.NewsHeadlinesResponse
import com.lbg.technicaltest.network.Resource
import com.lbg.technicaltest.network.repository.NewsHeadlinesRepository
import com.lbg.technicaltest.network.repository.NewsHeadlinesRepositoryImpl
import com.lbg.technicaltest.utils.CommonConstants.API_KEY
import com.lbg.technicaltest.utils.CommonConstants.SOURCE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NewsHeadLinesListViewModel: BaseViewModel() {

    private val newsHeadlinesRepository: NewsHeadlinesRepository by lazy {
        NewsHeadlinesRepositoryImpl(client)
    }
    private val _newsHeadlinesResponse = mutableStateOf<Resource<NewsHeadlinesResponse>?>(null)
    val newsHeadlinesResponse get() = _newsHeadlinesResponse

    fun getNewsHeadlinesData() {
        viewModelScope.launch(Dispatchers.IO) {

            newsHeadlinesRepository.getNewsHeadlinesData(
                sources = SOURCE,
                api = API_KEY
            ).collectLatest {
                _newsHeadlinesResponse.value = it
            }
        }
    }
}