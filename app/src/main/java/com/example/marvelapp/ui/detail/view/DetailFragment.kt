package com.example.marvelapp.ui.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.marvelapp.Constants.Constants
import com.example.marvelapp.R
import com.example.marvelapp.app.AppConfig
import com.example.marvelapp.databinding.FragmentDetailBinding
import com.example.marvelapp.dto.Results
import com.example.marvelapp.ui.detail.adapter.DetailAdapter
import com.example.marvelapp.utils.Utils
import java.lang.String


class DetailFragment : Fragment() {

    private val TAG = "DetailFragment"
    private lateinit var binding: FragmentDetailBinding
    private lateinit var data: Results
    lateinit var adapter: DetailAdapter

    companion object {
        private const val ARG_RESULT = "result"

        @JvmStatic
        fun newInstance(param1: Results?) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_RESULT, param1)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getParcelable(ARG_RESULT)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() {
        Glide.with(AppConfig.context!!)
            .load(data.thumbnail!!.path + Constants.UNCANNY_VARIANT_NAME + Constants.IMAGE_EXTENSION)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(binding.ivComic)

        binding.tvName.text = data.title
        binding.tvLastUpdate.text = String.format(
            AppConfig.context!!.getString(R.string.last_update), Utils.convertDate(data.modified!!)
        )

        binding.tvPages.text = String.format(
            AppConfig.context!!.getString(R.string.pages), data.pageCount.toString()
        )

        binding.tvPrice.text = String.format(
            AppConfig.context!!.getString(R.string.price), data.prices[0].price.toString()
        )

        if (data.description!!.isNotEmpty()) {
            binding.contentDescription.visibility = View.VISIBLE
            binding.tvDescription.text = data.description
        }

        if (data.creators!!.available!! > 0)
            setUpRecycler()
        else
            binding.contentCreators.visibility = View.GONE
    }

    private fun setUpRecycler() {
        adapter = DetailAdapter(requireActivity(), data.creators!!.items)
        binding.rvCreators.layoutManager = LinearLayoutManager(context)
        binding.rvCreators.setHasFixedSize(true)
        binding.rvCreators.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}