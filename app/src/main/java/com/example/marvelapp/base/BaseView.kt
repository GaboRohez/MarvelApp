package com.example.marvelapp.base

interface BaseView {
    fun showLoader()
    fun hideLoader()
    fun showErrorDialog(message: String?)
    fun showErrorDialog(resourceId: Int)
}