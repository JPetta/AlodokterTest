package com.example.alodoktertest.util

import android.content.Context
import android.content.SharedPreferences
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class SharedPrefManager(context: Context) {
    private val sp : SharedPreferences
    private val spEditor : SharedPreferences.Editor
    private val sdfDatePicked: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    companion object {
        const val ALODOKTER_APP = "ALODOKTER"
        const val LOGIN_STATUS = "loggedin"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }

    init {
        sp = context.getSharedPreferences(ALODOKTER_APP, Context.MODE_PRIVATE)
        spEditor = sp.edit()
        spEditor.apply()
    }

    val email : String?
        get() = sp.getString(EMAIL, "no-password")

    val password: String?
        get() = sp.getString(PASSWORD, "no-password")

    val isLoggedIn : Boolean
        get() = sp.getBoolean(LOGIN_STATUS, false)

    fun clear(keySP : String){
        spEditor.remove(keySP)
        spEditor.commit()
    }

    fun clearAll(){
        spEditor.clear().commit()
    }

    fun saveSPString(keySP : String, value : String?){
        spEditor.putString(keySP, value)
        spEditor.commit()
    }

    fun saveSPBoolean(keySP : String, value : Boolean){
        spEditor.putBoolean(keySP, value)
        spEditor.commit()
    }

    fun contains(keySP: String) : Boolean{
        return sp.contains(keySP)
    }
}