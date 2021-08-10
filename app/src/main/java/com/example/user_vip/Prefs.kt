package com.example.user_vip

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val SHARED_NAME = "MyDatabase"
    private val SHARED_KEY_NAME = "username"
    private val SHARED_KEY_VIP = "vip"

    private val storage: SharedPreferences = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name: String) {
        storage.edit().putString(SHARED_KEY_NAME, name).apply()
    }

    fun saveVip(isVip: Boolean) {
        storage.edit().putBoolean(SHARED_KEY_VIP, isVip).apply()
    }

    fun getName(): String {
        return storage.getString(SHARED_KEY_NAME, "")!!
    }

    fun getVip(): Boolean {
        return storage.getBoolean(SHARED_KEY_VIP, false)
    }

    fun wipe() {
        storage.edit().clear().apply()
    }
}