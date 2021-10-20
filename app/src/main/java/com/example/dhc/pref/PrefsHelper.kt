package com.example.dhc.pref

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PrefsHelper(context: Context) {
    companion object {
        // UUID
        const val PREF_UUID= "pref_uuid"

        // First Name
        const val PREF_FIRST_NAME = "pref_first_name"
    }

    val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var uuid: String?
        get() {
            val value = sp.getString(PREF_UUID, "")
            return value
        }
        set(value) {
            sp.edit().apply {
                if (value == null) {
                    remove(PREF_UUID)
                } else {
                    putString(PREF_UUID, value)
                }
            }.apply()
        }

    var firstName: String?
        get() {
            val value = sp.getString(PREF_FIRST_NAME, "")
            return value
        }
        set(value) {
            sp.edit().apply {
                if (value == null) {
                    remove(PREF_FIRST_NAME)
                } else {
                    putString(PREF_FIRST_NAME, value)
                }
            }.apply()
        }
}