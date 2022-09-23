package com.example.marvelapp.Constants

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {

    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
        const val VARIANT_NAME = "/portrait_xlarge"
        const val IMAGE_EXTENSION = ".jpg"

        const val API_KEY = "d59ba3645be7a778a5f77224b4dad5bb"
        private const val PRIVATE_KEY = "d85a1f86e76c3e174301a428fa2b789017873978"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}