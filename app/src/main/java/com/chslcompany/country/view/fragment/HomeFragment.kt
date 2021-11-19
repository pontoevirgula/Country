package com.chslcompany.country.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chslcompany.country.R
import com.chslcompany.country.core.util.ViewModelFactory
import com.chslcompany.country.data.model.CountryResponseItem
import com.chslcompany.country.data.model.Flags
import com.chslcompany.country.data.repository.CountryRepositoryImpl
import com.chslcompany.country.databinding.FragmentHomeBinding
import com.chslcompany.country.view.adapter.CountryAdapter
import com.chslcompany.country.view.viewmodel.CountryViewModel

class HomeFragment : Fragment() {

    private lateinit var countryViewModel : CountryViewModel
    private val countryAdapter: CountryAdapter by lazy {
        CountryAdapter(mutableListOf())
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        fetchData()
        setupObservers()
    }

    private fun setupViews() {
        binding.run {
            this.rvCountries.also {
                it.layoutManager = GridLayoutManager(
                    context, 2, RecyclerView.VERTICAL, false
                )
                it.adapter = countryAdapter
            }
            this.ivRefresh.setOnClickListener { fetchData() }
        }

        countryViewModel = ViewModelProvider(this,
            ViewModelFactory(CountryRepositoryImpl())
        )[CountryViewModel::class.java]
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
        countryViewModel.countriesLiveData.observe(viewLifecycleOwner,
            { countryResponseItems ->
                binding.pbLoading.visibility = View.GONE
                countryAdapter.update(countryResponseItems)
                setFlipper(countryResponseItems)
            }
        )

        countryViewModel.viewFlipperLiveData.observe(viewLifecycleOwner,
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

    override fun onDestroyView() {
        //EVITAR MEMORY LEAK
        _binding = null
        super.onDestroyView()
    }
}