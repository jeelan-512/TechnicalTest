package com.lbg.technicaltest.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Source(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String
): Parcelable