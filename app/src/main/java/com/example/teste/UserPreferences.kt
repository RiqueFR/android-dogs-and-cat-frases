package com.example.teste

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {

    private val sp: SharedPreferences =
        context.getSharedPreferences(Constants.user_key, Context.MODE_PRIVATE)

    fun setString(key: String, str: String) {
        sp.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "") ?: ""
    }
}