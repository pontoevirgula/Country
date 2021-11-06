package com.chslcompany.country

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ViewFlipper
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.chslcompany.country.model.Flags

class CustomCarouselFlipper(context: Context?, attrs: AttributeSet?) : ViewFlipper(context, attrs) {

    private var flagList = mutableListOf<Flags>()

    fun setList(mutableList: MutableList<Flags>) {
        this.flagList = mutableList
    }

    fun setLayoutCarousel() {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        this.setInAnimation(context, android.R.anim.slide_in_left)
        this.setOutAnimation(context, android.R.anim.slide_out_right)

        for (i in flagList.indices) {
            val view = inflater.inflate(R.layout.item_carousel_flag, this, false)
            val imgCarouselFlags = view.findViewById(R.id.ivCarouselFlag) as AppCompatImageView

            flagList[i].svg?.let {
                imgCarouselFlags.loadSvg(it)
            } ?: run {
                Glide.with(context).load(flagList[i].png).into(imgCarouselFlags)
            }
            this.addView(view, i)
        }
    }
}