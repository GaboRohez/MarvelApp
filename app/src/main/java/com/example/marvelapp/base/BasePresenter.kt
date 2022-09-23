package com.example.marvelapp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<T>(view: T) {

    var view: T? = null
    private val mCompositeDisposable: CompositeDisposable
    val isViewAttached: Boolean
        get() = view != null

    fun addSubscription(disposable: Disposable?) {
        mCompositeDisposable.add(disposable!!)
    }

    fun detachView() {
        mCompositeDisposable.clear()
        view = null
    }

    init {
        this.view = view
        mCompositeDisposable = CompositeDisposable()
    }

}