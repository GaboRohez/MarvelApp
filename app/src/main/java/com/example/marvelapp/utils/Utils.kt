package com.example.marvelapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {
        @SuppressLint("SimpleDateFormat")
        fun convertDate(dateString: String): String {
            val dateInput = "yyyy-MM-dd'T'HH:mm:ss"
            val dateOutput = "yyyy-MM-dd"

            val formatInput = SimpleDateFormat(dateInput)
            val formatOutput = SimpleDateFormat(dateOutput)

            val date: Date? = formatInput.parse(dateString)
            return formatOutput.format(date!!)
        }
    }
}