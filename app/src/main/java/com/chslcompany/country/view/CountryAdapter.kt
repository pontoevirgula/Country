package com.chslcompany.country.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chslcompany.country.R
import com.chslcompany.country.databinding.ItemCountryBinding
import com.chslcompany.country.loadSvg
import com.chslcompany.country.model.CountryResponseItem

class CountryAdapter(private val countryItemList : MutableList<CountryResponseItem>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var lastPosition = -1
    private lateinit var bindingAdapter: ItemCountryBinding

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       holder.bind(countryItemList[position])
       animation(holder.itemView,position)
    }
    override fun getItemCount() = countryItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CountryViewHolder{
        bindingAdapter = ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(bindingAdapter)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(countryItems: List<CountryResponseItem>) {
        if (!countryItems.isNullOrEmpty()) {
            countryItemList.clear()
            countryItemList.addAll(countryItems)
            notifyDataSetChanged()
        }
    }

    private fun animation(view: View, position: Int){
        lastPosition = if (position > lastPosition){
            val animation = AnimationUtils.loadAnimation(view.context,android.R.anim.slide_in_left)
            view.startAnimation(animation)
            position
        } else{
            val animation = AnimationUtils.loadAnimation(view.context,android.R.anim.slide_out_right)
            view.startAnimation(animation)
            position
        }
    }

    class CountryViewHolder(private val bindingAdapter : ItemCountryBinding)
                            : RecyclerView.ViewHolder(bindingAdapter.root) {

        fun bind(countryResponseItem: CountryResponseItem){
            countryResponseItem.translations.por?.common.let{
                    bindingAdapter.countryName.text = it
            }
            countryResponseItem.flags.svg?.let {
                bindingAdapter.ivCountry.loadSvg(it)
            }?:run {
                    Glide.with(itemView.context)
                        .load(countryResponseItem.flags.png)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_background)
                        .into(bindingAdapter.ivCountry)
            }
         }
    }
}