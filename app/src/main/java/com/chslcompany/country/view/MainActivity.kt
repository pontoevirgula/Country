package com.chslcompany.country.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chslcompany.country.databinding.ActivityMainBinding
import com.chslcompany.country.model.CountryResponseItem
import com.chslcompany.country.model.Flags
import com.chslcompany.country.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {

    private val countryViewModel: CountryViewModel by lazy {
        ViewModelProvider(this)[CountryViewModel::class.java]
    }
    private val countryAdapter: CountryAdapter by lazy {
        CountryAdapter(mutableListOf())
    }
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        fetchData()
        setupObservers()
    }

    private fun setupViews() {
        _binding = ActivityMainBinding.inflate(layoutInflater)

        binding.run {
            rvCountries.apply {
                layoutManager = GridLayoutManager(
                    context, 2, RecyclerView.VERTICAL, false
                )
                adapter = countryAdapter
            }

            ivRefresh.setOnClickListener { fetchData() }

            setContentView(root)
        }
    }

    private fun setFlipper(countries: List<CountryResponseItem>) {
        val flags = mutableListOf<Flags>()
        countries.forEach {
            flags.add(it.flags)
        }
        binding.customFlipper.setList(flags)
        binding.customFlipper.setLayoutCarousel()
    }


    private fun setupObservers() {
        countryViewModel.countriesLiveData.observe(this,
            { countryResponseItems ->
                binding.pbLoading.visibility = View.GONE
                countryAdapter.update(countryResponseItems)
                setFlipper(countryResponseItems)
            }
        )

        countryViewModel.viewFlipperLiveData.observe(this,
            {
                it?.let { viewFlipper ->
                    binding.run {
                        pbLoading.visibility = View.GONE
                        viewFlipperCountries.displayedChild = viewFlipper.first
                        viewFlipper.second?.let { errorMessageId ->
                            rlError.visibility = View.VISIBLE
                            tvError.text = getString(errorMessageId)
                        }
                    }
                }
            }
        )

    }

    private fun fetchData() = countryViewModel.fetchCountries()

    override fun onDestroy() {
        //EVITAR MEMORY LEAK
        _binding = null
        super.onDestroy()
    }
}