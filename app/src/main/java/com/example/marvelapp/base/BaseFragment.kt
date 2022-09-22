package com.example.marvelapp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

class BaseFragment<T, B : ViewBinding?> : Fragment(), BaseView {

    var presenter: T? = null
    var binding: B? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun addFragment(fragment: Fragment?, TAG: String?, id: Int) {
        if (fragment == null) return
        val fm = requireActivity().supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(id, fragment)
        tr.commitAllowingStateLoss()
    }

}