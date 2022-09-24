package com.example.marvelapp.ui.comics_list.Interactor

import com.example.marvelapp.Constants.Constants
import com.example.marvelapp.api.EndPoint
import com.example.marvelapp.api.RetrofitClient
import com.example.marvelapp.dto.ComicsResponse
import com.example.marvelapp.ui.comics_list.Presenter.ComicsContract
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ComicsInteractor : ComicsContract.Interactor {
    override fun getAllComics(offset: Int, limit: Int): Single<Response<ComicsResponse>> {
        return RetrofitClient.instance
            .create(EndPoint::class.java)
            .getAllComics(Constants.API_KEY, Constants.timeStamp, Constants.hash(), offset, limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}