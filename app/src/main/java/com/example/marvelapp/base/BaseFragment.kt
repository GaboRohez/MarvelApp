package com.example.marvelapp.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.marvelapp.R
import com.example.marvelapp.custom.CustomLoader

open class BaseFragment<T, B : ViewBinding?> : Fragment(), BaseView {

    protected var presenter: T? = null
    protected var binding: B? = null
    private var loader: CustomLoader? = null

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

    override fun showLoader() {
        getLoader()!!.show(childFragmentManager, CustomLoader::class.java.name)
    }

    override fun hideLoader() {
        getLoader()!!.dismiss()
    }

    override fun showErrorDialog(message: String?) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(message)
            builder.apply {
                setPositiveButton(
                    R.string.accept
                ) { dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.create()
        }
        alertDialog!!.show()
    }

    override fun showErrorDialog(resourceId: Int) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(getString(resourceId))
            builder.apply {
                setPositiveButton(
                    R.string.accept
                ) { dialog, _ ->
                    dialog.dismiss()
                }
            }
            builder.create()
        }
        alertDialog!!.show()
    }

    open fun getLoader(): CustomLoader? {
        return if (loader != null) loader else CustomLoader().also { loader = it }
    }
}