package com.chslcompany.country.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chslcompany.country.R
import com.chslcompany.country.core.bases.BaseViewModel
import com.chslcompany.country.data.model.CountryResponseItem
import com.chslcompany.country.data.repository.CountryRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel(private val repositoryImpl: CountryRepositoryImpl) : BaseViewModel() {
    val countriesLiveData: MutableLiveData<List<CountryResponseItem>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repositoryImpl.getCountries()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    if (response.body().isNullOrEmpty()) {
                        viewFlipperLiveData.value =
                            Pair(VIEW_FLIPPER_ERROR, R.string.error_generic)
                    } else {
                        countriesLiveData.value = response.body()
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_COUNTRIES, null)
                    }
                }
            }
        }

    }

    companion object {
        private const val VIEW_FLIPPER_COUNTRIES = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}


