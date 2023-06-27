package com.familyaura.todo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.familyaura.todo.data.BuyData
import com.familyaura.carer.databinding.BuyItemBinding

class BuyListAdapter(val context: Context, val list: List<BuyData>) :
    RecyclerView.Adapter<BuyListAdapter.NotificationsListHolder>() {

    inner class NotificationsListHolder(val binding: BuyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsListHolder {
        val binding =
            BuyItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return NotificationsListHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationsListHolder, position: Int) {
        val buyData = list[position]

        holder.binding.tvName.text = buyData.name
        holder.binding.tvPrice.text = buyData.price.toString()
        holder.binding.tvQuantity.text = buyData.quantity.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}