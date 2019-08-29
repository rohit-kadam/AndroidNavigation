package com.androidnavigation

import android.content.Context
import android.content.SharedPreferences

open class SharedPref {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    constructor(context: Context, name: String) {
        this.pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    fun putString(key: String, value: String) {
        editor.apply {
            putString(key, value)
        }
    }

    fun getString(key: String, default: String): String? {
        return pref.getString(key, default)
    }

    fun putInt(key: String, value: Int) {
        editor.apply {
            putInt(key, value)
        }
    }

    fun getInt(key: String, default: Int): Int? {
        return pref.getInt(key, default)
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.apply {
            putBoolean(key, value)
        }
    }

    fun getBoolean(key: String, default: Boolean): Boolean? {
        return pref.getBoolean(key, default)
    }

    fun remove(key: String) {
        editor.apply {
            remove(key)
        }
    }

    fun clear() {
        editor.clear()
        apply()
    }

    fun commit() {
        editor.commit()
    }

    fun apply() {
        editor.apply()
    }
}