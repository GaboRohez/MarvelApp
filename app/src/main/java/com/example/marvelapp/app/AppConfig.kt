package com.example.marvelapp.app

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.example.marvelapp.R

class AppConfig : Application() {

    companion object {
        var context: Context? = null
        var resourceManager: AndroidResourceManager? = null

        fun getAppContext(): Context? {
            return context!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        resourceManager =
            AndroidResourceManager(
                resources
            )
    }

    class AndroidResourceManager(private val resources: Resources) {
        val getAppName: String
            get() = resources.getString(R.string.app_name)
        val getCommonError: String
            get() = resources.getString(R.string.common_error)
        val getMaxItemError: String
            get() = resources.getString(R.string.error_maximum_items)
    }

}