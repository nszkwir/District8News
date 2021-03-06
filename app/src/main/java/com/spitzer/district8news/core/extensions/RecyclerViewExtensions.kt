package com.spitzer.district8news.core.extensions

import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder> T.listenToClick(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}
