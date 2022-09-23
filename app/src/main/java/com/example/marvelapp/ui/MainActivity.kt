package com.example.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.marvelapp.R
import com.example.marvelapp.ui.comics_list.View.ComicsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(
            ComicsListFragment(),
            ComicsListFragment::class.java.name,
            R.id.contentFragment
        )
    }

    protected fun replaceFragment(fragment: Fragment?, TAG: String?, id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment!!, TAG)
            .commit()
    }
}