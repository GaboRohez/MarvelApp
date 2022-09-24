package com.example.marvelapp.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.databinding.ItemRoleBinding
import com.example.marvelapp.dto.Items

class DetailAdapter(context: Context, private val list: ArrayList<Items>) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return DetailAdapter.ViewHolder(
            ItemRoleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvRole.text = list[position].role
        holder.binding.tvName.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: ItemRoleBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ItemRoleBinding

        init {
            this.binding = binding
        }
    }
}