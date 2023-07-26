package com.example.dotoring

import android.app.Application
import com.example.dotoring.ui.login.data.TokenSharedPreferences

class MyApplication: Application() {
    companion object{
        lateinit var token_prefs : TokenSharedPreferences
    }

    override fun onCreate() {
        token_prefs = TokenSharedPreferences(applicationContext)
        super.onCreate()
    }
}