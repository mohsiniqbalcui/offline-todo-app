package com.familyaura.todo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.familyaura.todo.data.CallData
import com.familyaura.carer.databinding.CallItemBinding

class CallListAdapter(val context: Context, val list: List<CallData>) :
    RecyclerView.Adapter<CallListAdapter.NotificationsListHolder>() {

    inner class NotificationsListHolder(val binding: CallItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsListHolder {
        val binding =
            CallItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return NotificationsListHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationsListHolder, position: Int) {
        val buyData = list[position]

        holder.binding.tvName.text = buyData.name
        holder.binding.tvNumber.text = buyData.number.toString()
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