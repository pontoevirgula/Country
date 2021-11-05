package com.chslcompany.country.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chslcompany.country.databinding.ActivityMainBinding
import com.chslcompany.country.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {

    private val countryViewModel: CountryViewModel by lazy {
        ViewModelProvider(this)[CountryViewModel::class.java]
    }
    private val countryAdapter : CountryAdapter by lazy {
        CountryAdapter(arrayListOf())
    }
    private var _binding : ActivityMainBinding? = null
    private val binding = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        binding.rvCountries.apply {
            layoutManager = GridLayoutManager(
                context,2,RecyclerView.VERTICAL, false)
            adapter = countryAdapter
        }

        fetchData()
        setupObservers()
        binding.ivRefresh.setOnClickListener { fetchData() }
        setContentView(binding.root)
    }

    private fun setupObservers() {
        countryViewModel.countriesLiveData.observe(this,
            { countryResponseItems ->
                binding.pbLoading.visibility = View.GONE
                countryAdapter.update(countryResponseItems)
            }
        )

        countryViewModel.viewFlipperLiveData.observe(this,
            {
                it?.let { viewFlipper ->
                    binding.pbLoading.visibility = View.GONE
                    binding.viewFlipperCountries.displayedChild = viewFlipper.first
                    viewFlipper.second?.let { errorMessageId ->
                        binding.rlError.visibility = View.VISIBLE
                        binding.tvError.text = getString(errorMessageId)
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