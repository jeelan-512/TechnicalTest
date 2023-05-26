package com.lbg.technicaltest.viewmodel

import androidx.lifecycle.ViewModel
import com.lbg.technicaltest.network.ApiService
import com.lbg.technicaltest.network.ktorHttpClient
import com.lbg.technicaltest.utils.ParameterConstants.BASE_URL

open class BaseViewModel: ViewModel(){
    val client by lazy {
        ApiService(
            client = ktorHttpClient,
            BASE_URL
        )
    }
}