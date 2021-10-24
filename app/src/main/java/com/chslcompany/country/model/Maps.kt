package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Maps(
    @SerialName("googleMaps")
    val googleMaps: String,
    @SerialName("openStreetMaps")
    val openStreetMaps: String
)