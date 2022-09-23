package com.example.marvelapp.ui.comics_list.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.FragmentComicsListBinding
import com.example.marvelapp.dto.Results
import com.example.marvelapp.ui.comics_list.Presenter.ComicsContract
import com.example.marvelapp.ui.comics_list.Presenter.ComicsPresenter
import com.example.marvelapp.ui.comics_list.adapter.ComicsAdapter

class ComicsListFragment : BaseFragment<ComicsContract.Presenter, FragmentComicsListBinding>(),
    ComicsContract.View,
    ComicsAdapter.ComicsIn {

    private val TAG = "ComicsListFragment"

    lateinit var adapter: ComicsAdapter
    var comicsList: ArrayList<Results> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ComicsPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        presenter!!.getAllComics()
    }

    private fun setUpRecycler() {
        adapter = ComicsAdapter(requireActivity(), comicsList, this)
        binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        binding!!.recyclerView.setHasFixedSize(true)
        binding!!.recyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    override fun showComics(comics: ArrayList<Results>) {
        comicsList.clear()
        comicsList.addAll(comics)
        adapter.notifyDataSetChanged()
    }

    override fun onComicClick(comic: Results?) {
        Toast.makeText(requireActivity(), comic!!.title, Toast.LENGTH_LONG).show()
    }
}