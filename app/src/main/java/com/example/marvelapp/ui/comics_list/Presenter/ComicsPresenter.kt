package com.example.marvelapp.ui.comics_list.Presenter

import android.util.Log
import com.example.marvelapp.base.BasePresenter
import com.example.marvelapp.ui.comics_list.Interactor.ComicsInteractor

class ComicsPresenter(view: ComicsContract.View?) : BasePresenter<ComicsContract.View?>(view),
    ComicsContract.Presenter {

    private val TAG = "ComicsPresenter"

    private val interactor: ComicsContract.Interactor

    init {
        this.interactor = ComicsInteractor()
    }

    override fun getAllComics() {
        addSubscription(interactor.getAllComics()
            .doOnSubscribe {
                //disposable -> view.showLoader()
            }
            .doFinally {
                //view.hideLoader()
            }
            .subscribe({ response ->
                Log.d(TAG, "getAllComics: " + response.body())
            }) { throwable ->
                Log.d(TAG, "getAllComics: " + throwable.message)
            })
    }
}