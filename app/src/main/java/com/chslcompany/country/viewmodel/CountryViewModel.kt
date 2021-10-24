package com.chslcompany.country.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chslcompany.country.R
import com.chslcompany.country.model.CountryResponseItem
import com.chslcompany.country.service.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel : ViewModel() {
    var repository = CountryRepository()
    val countriesLiveData : MutableLiveData<List<CountryResponseItem>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun fetchCountries(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getCountries()
            if (response.isSuccessful){
                withContext(Dispatchers.Main){
                   if (!response.body().isNullOrEmpty()){
                        countriesLiveData.value = response.body()
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_COUNTRIES, null)
                    } else {
                        viewFlipperLiveData.value =
                            Pair(VIEW_FLIPPER_ERROR, R.string.error_generic)
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