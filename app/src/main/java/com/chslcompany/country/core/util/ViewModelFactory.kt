package com.chslcompany.country.core.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chslcompany.country.data.repository.CountryRepositoryImpl
import com.chslcompany.country.view.viewmodel.CountryViewModel

class ViewModelFactory(private val repositoryImpl: CountryRepositoryImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(repositoryImpl) as T
    }
}