package com.example.marvelapp.ui.comics_list.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.FragmentComicsListBinding
import com.example.marvelapp.dto.Results
import com.example.marvelapp.ui.comics_list.Presenter.ComicsContract
import com.example.marvelapp.ui.comics_list.Presenter.ComicsPresenter
import com.example.marvelapp.ui.comics_list.adapter.ComicsAdapter


class ComicsListFragment : BaseFragment<ComicsContract.Presenter, FragmentComicsListBinding>(),
    ComicsContract.View,
    ComicsAdapter.ComicsIn {

    private var isFirstTime: Boolean = true
    private val TAG = "ComicsListFragment"
    private var offset: Int = 0
    private var limit: Int = 20
    private var readyToLoad = false

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
        if (binding == null) {
            binding = FragmentComicsListBinding.inflate(inflater, container, false)
        }
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isFirstTime) {
            setUpRecycler()
            setUpEvents()
            presenter!!.getAllComics(offset, limit)
            isFirstTime = false
        }
    }

    private fun setUpRecycler() {
        adapter = ComicsAdapter(requireActivity(), comicsList, this)
        binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        binding!!.recyclerView.setHasFixedSize(true)
        binding!!.recyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    private fun setUpEvents() {
        binding!!.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleItemCount: Int = binding!!.recyclerView.layoutManager!!.childCount
                    val totalItemCount: Int = binding!!.recyclerView.layoutManager!!.itemCount
                    val pastVisibleItems =
                        (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (readyToLoad) {
                        if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                            readyToLoad = false
                            offset += 20
                            limit += 20
                            presenter!!.getAllComics(offset, limit)
                        }
                    }
                }
            }
        })
    }

    override fun showComics(comics: ArrayList<Results>) {
        readyToLoad = true
        comicsList.addAll(comics)
        adapter.notifyDataSetChanged()
    }

    override fun onComicClick(comic: Results?) {
        var bundle = bundleOf("result" to comic)
        view?.findNavController()?.navigate(R.id.detailFragment, bundle)
    }
}