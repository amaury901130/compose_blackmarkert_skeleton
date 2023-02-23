package com.rs.data

import android.content.SharedPreferences

/*
*
    access-token:nbEQO2n6deJg30MANAj07A
    token_type:Bearer
    client:scVmURyrFzzp_F-Fk94hpQ
    expiry:1649441182
    uid:test@example.com
*
* */

class DataPreferences(val prefs: SharedPreferences) {

    var accessToken: String
        get() = getString(ACCESS_TOKEN)
        set(value) = setString(ACCESS_TOKEN, value)

    var typeToken: String
        get() = getString(TOKEN_TYPE)
        set(value) = setString(TOKEN_TYPE, value)

    var uidToken: String
        get() = getString(UUID)
        set(value) = setString(UUID, value)

    var clientToken: String
        get() = getString(CLIENT)
        set(value) = setString(CLIENT, value)

    var expireToken: String
        get() = getString(EXPIRE)
        set(value) = setString(EXPIRE, value)

    private fun getString(key: String): String {
        return prefs.getString(key, EMPTY) ?: EMPTY
    }

    private fun setString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    companion object {
        const val ACCESS_TOKEN = "access_token"
        const val TOKEN_TYPE = "token_type"
        const val CLIENT = "client"
        const val UUID = "uid"
        const val EXPIRE = "expire"
        const val EMPTY = ""
    }
}