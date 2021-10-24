package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryResponseItem(
    @SerialName("altSpellings")
    val altSpellings: List<String>,
    @SerialName("area")
    val area: Double,
    @SerialName("borders")
    val borders: List<String>,
    @SerialName("capital")
    val capital: List<String>,
    @SerialName("capitalInfo")
    val capitalInfo: CapitalInfo,
    @SerialName("car")
    val car: Car,
    @SerialName("cca2")
    val cca2: String,
    @SerialName("cca3")
    val cca3: String,
    @SerialName("ccn3")
    val ccn3: String,
    @SerialName("cioc")
    val cioc: String,
    @SerialName("coatOfArms")
    val coatOfArms: CoatOfArms,
    @SerialName("continents")
    val continents: List<String>,
    @SerialName("currencies")
    val currencies: Currencies,
    @SerialName("demonyms")
    val demonyms: Demonyms,
    @SerialName("fifa")
    val fifa: String,
    @SerialName("flag")
    val flag: String,
    @SerialName("flags")
    val flags: Flags,
    @SerialName("gini")
    val gini: Gini,
    @SerialName("idd")
    val idd: Idd,
    @SerialName("independent")
    val independent: Boolean,
    @SerialName("landlocked")
    val landlocked: Boolean,
    @SerialName("languages")
    val languages: Languages,
    @SerialName("latlng")
    val latlng: List<Double>,
    @SerialName("maps")
    val maps: Maps,
    @SerialName("name")
    val name: Name,
    @SerialName("population")
    val population: Int,
    @SerialName("postalCode")
    val postalCode: PostalCode,
    @SerialName("region")
    val region: String,
    @SerialName("startOfWeek")
    val startOfWeek: String,
    @SerialName("status")
    val status: String,
    @SerialName("subregion")
    val subregion: String,
    @SerialName("timezones")
    val timezones: List<String>,
    @SerialName("tld")
    val tld: List<String>,
    @SerialName("translations")
    val translations: Translations,
    @SerialName("unMember")
    val unMember: Boolean
)