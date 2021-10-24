package com.chslcompany.country.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chslcompany.country.R
import com.chslcompany.country.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countryViewModel: CountryViewModel
    private val countryAdapter : CountryAdapter by lazy {
        CountryAdapter(arrayListOf())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryViewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        rvCountries.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }

        countryViewModel.countriesLiveData.observe(this, Observer { countryResponseItem->
            pbLoading.visibility = View.GONE
                countryAdapter.update(countryResponseItem)
            }
        )

        countryViewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper->
                pbLoading.visibility = View.GONE
                viewFlipperCountries.displayedChild = viewFlipper.first
                viewFlipper.second?.let { errorMessageId->
                    tvError.text = getString(errorMessageId)
                }
            }
        })

        countryViewModel.fetchCountries()

    }


}