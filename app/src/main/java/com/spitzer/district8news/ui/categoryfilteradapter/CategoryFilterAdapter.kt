package com.spitzer.district8news.ui.categoryfilteradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spitzer.district8news.R
import com.spitzer.district8news.core.extensions.listenToClick
import com.spitzer.district8news.databinding.CategoryFilterItemBinding

class CategoryFilterAdapter(private var items: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<CategoryFilterAdapter.ViewHolder>() {

    lateinit var onItemClick: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val item =
            CategoryFilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(item).listenToClick { position, _ ->
            onItemClick(position)
        }
    }

    // TODO optimize recyclerviews with ListAdapters to update single elements
    fun updateData(newData: ArrayList<CategoryModel>) {
        items = newData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun onItemClickFunction(itemClickFunction: (Int) -> Unit) {
        onItemClick = itemClickFunction
    }

    inner class ViewHolder(
        private val itemBinding: CategoryFilterItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: CategoryModel) {
            itemBinding.categoryDivisor.visibility = if (item.isLastItem) {
                View.GONE
            } else {
                View.VISIBLE
            }
            if (item.isSelected) {
                itemBinding.checkIcon.setImageResource(R.drawable.ic_check_box_filled)
            } else {
                itemBinding.checkIcon.setImageResource(R.drawable.ic_check_box_blank)
            }
            itemBinding.categoryName.text = item.category.name
        }
    }
}