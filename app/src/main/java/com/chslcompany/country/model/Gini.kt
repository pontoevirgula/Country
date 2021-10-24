package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Gini(
    @SerialName("2018")
    val x2018: Double
)