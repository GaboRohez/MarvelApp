package com.example.marvelapp.ui.comics_list.Presenter

import com.example.marvelapp.base.BaseView
import com.example.marvelapp.dto.ComicsResponse
import com.example.marvelapp.dto.Results
import io.reactivex.Single
import retrofit2.Response

interface ComicsContract {
    interface View : BaseView {
        fun showComics(comics: ArrayList<Results>)
    }

    interface Presenter {
        fun getAllComics(offset: Int, limit: Int)

    }

    interface Interactor {
        fun getAllComics(offset: Int, limit: Int): Single<Response<ComicsResponse>>
    }
}