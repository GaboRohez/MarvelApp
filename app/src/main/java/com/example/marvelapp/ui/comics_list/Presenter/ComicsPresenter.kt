package com.example.marvelapp.ui.comics_list.Presenter

import com.example.marvelapp.Constants.Constants
import com.example.marvelapp.app.AppConfig
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
        addSubscription(interactor
            .getAllComics()
            .doOnSubscribe { disposable -> view!!.showLoader() }
            .doAfterTerminate { view!!.hideLoader() }
            .subscribe({ response ->
                if (Constants.SUCCESS == response.body()!!.code) {
                    view!!.showComics(response.body()!!.data!!.results)
                } else {
                    view!!.showErrorDialog(AppConfig.resourceManager!!.getCommonError)
                }
            }) { throwable ->
                view!!.showErrorDialog(processError(throwable))
            })
    }
}