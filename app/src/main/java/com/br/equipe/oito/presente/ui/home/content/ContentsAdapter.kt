package com.br.equipe.oito.presente.ui.home.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.model.Content
import com.bumptech.glide.Glide

class ContentsAdapter(private val contents: List<Content>, private val callback: () -> Unit) :
    RecyclerView.Adapter<ContentsAdapter.ContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(contents[position])
    }

    override fun getItemCount() = contents.size

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.ivContentImage)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvContentTitle)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tvContentDescription)

        fun bind(content: Content) {
            Glide.with(imageView)
                .load(content.image)
                .into(imageView)
            tvTitle.text = content.title
            tvDescription.text = content.description
            itemView.setOnClickListener { callback.invoke() }
        }
    }

}