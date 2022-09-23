package com.example.marvelapp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<T, B : ViewBinding?> : Fragment(), BaseView {

    protected var presenter: T? = null
    protected var binding: B? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    protected open fun addFragment(fragment: Fragment?, TAG: String?, id: Int) {
        if (fragment == null) return
        val fm = activity!!.supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(id, fragment)
        tr.commitAllowingStateLoss()
    }

}