package com.example.marvelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun replaceFragment(fragment: Fragment?, TAG: String?, id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment!!, TAG)
            .commit()
    }
}