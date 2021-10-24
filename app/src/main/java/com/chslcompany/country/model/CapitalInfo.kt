package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CapitalInfo(
    @SerialName("latlng")
    val latlng: List<Double>
)