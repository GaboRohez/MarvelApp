package com.example.marvelapp.ui.comics_list.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.FragmentComicsListBinding
import com.example.marvelapp.ui.comics_list.Presenter.ComicsContract
import com.example.marvelapp.ui.comics_list.Presenter.ComicsPresenter

class ComicsListFragment : BaseFragment<ComicsContract.Presenter, FragmentComicsListBinding>(),
    ComicsContract.View {

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
        presenter!!.getAllComics()
    }

}