package com.lbg.technicaltest.model.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorApiResponse(
    @SerialName("error")
    val error: String?
)