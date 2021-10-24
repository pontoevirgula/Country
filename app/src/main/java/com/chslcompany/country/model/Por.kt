package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Por(
    @SerialName("common")
    val common: String,
    @SerialName("official")
    val official: String
)