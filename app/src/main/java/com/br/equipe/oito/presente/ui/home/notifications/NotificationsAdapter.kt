package com.br.equipe.oito.presente.ui.home.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.equipe.oito.presente.R
import com.br.equipe.oito.presente.model.Notification
import com.bumptech.glide.Glide

class NotificationsAdapter(private val notifications: List<Notification>) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.notification_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(notifications[position])
    }

    override fun getItemCount() = notifications.size

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.ivNotificationItem)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvNotificationTitle)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tvNotificationDescription)

        fun bind(notification: Notification) {
            Glide.with(imageView)
                .load(notification.image)
                .into(imageView)
            tvTitle.text = notification.title
            tvDescription.text = notification.description
        }
    }

}