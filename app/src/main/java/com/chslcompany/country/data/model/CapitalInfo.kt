package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CapitalInfo(
    @SerialName("latlng")
    val latlng: List<Double>
)