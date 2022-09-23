package com.example.marvelapp.ui.comics_list.Interactor

import com.example.marvelapp.api.EndPoint
import com.example.marvelapp.api.RetrofitClient
import com.example.marvelapp.dto.ComicsResponse
import com.example.marvelapp.ui.comics_list.Presenter.ComicsContract
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ComicsInteractor : ComicsContract.Interactor {
    override fun getAllComics(): Single<Response<ComicsResponse>> {
        return RetrofitClient.instance
            .create(EndPoint::class.java)
            .getAllComics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}