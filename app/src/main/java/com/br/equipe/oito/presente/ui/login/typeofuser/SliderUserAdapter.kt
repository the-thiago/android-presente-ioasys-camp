package com.br.equipe.oito.presente.ui.login.typeofuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.equipe.oito.presente.R

class SliderUserAdapter(private val slideImages: List<Int>) :
    RecyclerView.Adapter<SliderUserAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slide_user_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(slideImages[position])
    }

    override fun getItemCount() = slideImages.size

    inner class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageTypeOfUser)

        fun bind(imageResource: Int) {
            imageView.setImageResource(imageResource)
        }
    }

}