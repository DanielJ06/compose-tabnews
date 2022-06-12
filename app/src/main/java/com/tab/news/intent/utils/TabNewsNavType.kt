package com.tab.news.intent.utils

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.tab.news.intent.decode

class TabNewsNavType<T : Parcelable>(
    private val type: Class<T>,
    isNullableAllowed: Boolean = false,
) : NavType<T>(isNullableAllowed = isNullableAllowed) {

    override fun get(bundle: Bundle, key: String): T? = bundle.getParcelable(key)

    override fun parseValue(value: String): T = Gson().fromJson(value.decode(), type)

    override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)
}
