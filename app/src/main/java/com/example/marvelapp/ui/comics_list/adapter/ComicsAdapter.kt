package com.example.marvelapp.ui.comics_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.marvelapp.Constants.Constants
import com.example.marvelapp.R
import com.example.marvelapp.app.AppConfig.Companion.context
import com.example.marvelapp.databinding.ComicItemBinding
import com.example.marvelapp.dto.Results
import com.example.marvelapp.utils.Utils
import java.lang.String

class ComicsAdapter(
    context: Context,
    private val list: ArrayList<Results>,
    val listener: ComicsIn
) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    private val TAG = "ComicsAdapter"

    interface ComicsIn {
        fun onComicClick(comic: Results?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ComicsAdapter.ViewHolder(
            ComicItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = list[position].title
        holder.binding.tvDate.text = String.format(
            context!!.getString(R.string.last_update),
            Utils.convertDate(list[position].modified!!)
        )

        Glide.with(context!!)
            .load(list[position].thumbnail!!.path + Constants.VARIANT_NAME + Constants.IMAGE_EXTENSION)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(holder.binding.ivComic)

        holder.binding.root.setOnClickListener { listener.onComicClick(list[position]) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: ComicItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: ComicItemBinding

        init {
            this.binding = binding
        }
    }
}