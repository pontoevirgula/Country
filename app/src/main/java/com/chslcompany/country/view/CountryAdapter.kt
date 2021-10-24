package com.chslcompany.country.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.chslcompany.country.R
import com.chslcompany.country.model.CountryResponseItem
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(private val countryItemList : ArrayList<CountryResponseItem>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var lastPosition = -1

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       holder.bind(countryItemList[position])
       animation(holder.itemView,position)
    }
    override fun getItemCount() = countryItemList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    fun update(countryItems: List<CountryResponseItem>) {
        if (!countryItems.isNullOrEmpty()) {
            countryItemList.clear()
            countryItemList.addAll(countryItems)
            notifyDataSetChanged()
        }
    }

    private fun animation(view: View, position: Int){
        if (position > lastPosition){
            val animation = AnimationUtils.loadAnimation(view.context,android.R.anim.slide_in_left)
            view.startAnimation(animation)
            lastPosition = position
        } else{
            val animation = AnimationUtils.loadAnimation(view.context,android.R.anim.slide_out_right)
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(countryResponseItem: CountryResponseItem){
            countryResponseItem.name.common.let{
                    itemView.countryName.text = it
            }
         }
    }
}