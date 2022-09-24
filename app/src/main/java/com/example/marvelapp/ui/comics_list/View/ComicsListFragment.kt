package com.example.marvelapp.ui.comics_list.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.FragmentComicsListBinding
import com.example.marvelapp.dto.Results
import com.example.marvelapp.ui.comics_list.Presenter.ComicsContract
import com.example.marvelapp.ui.comics_list.Presenter.ComicsPresenter
import com.example.marvelapp.ui.comics_list.adapter.ComicsAdapter
import com.example.marvelapp.ui.detail.view.DetailFragment


class ComicsListFragment : BaseFragment<ComicsContract.Presenter, FragmentComicsListBinding>(),
    ComicsContract.View,
    ComicsAdapter.ComicsIn {

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
        binding = FragmentComicsListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        setUpEvents()
        presenter!!.getAllComics(offset, limit)
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
        addFragment(
            DetailFragment.newInstance(comic),
            DetailFragment::class.java.name,
            R.id.contentFragment
        )
        //Toast.makeText(requireActivity(), comic!!.title, Toast.LENGTH_LONG).show()
    }
}