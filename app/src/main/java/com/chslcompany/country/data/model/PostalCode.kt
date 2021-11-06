package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostalCode(
    @SerialName("format")
    val format: String,
    @SerialName("regex")
    val regex: String
)