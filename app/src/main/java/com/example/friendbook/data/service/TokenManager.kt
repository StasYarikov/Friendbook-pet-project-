package com.example.friendbook.data.service

import android.content.Context
import com.example.friendbook.data.entity.TokenResponse
import androidx.core.content.edit

class TokenManager(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("gigachat_prefs", Context.MODE_PRIVATE)
    private var currentToken: String? = null

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_EXPIRES_AT = "expires_at"
        private const val TOKEN_EXPIRY_BUFFER = 5 * 60 * 1000
    }

    fun getToken(): String? {
        if (currentToken == null) {
            currentToken = sharedPreferences.getString(KEY_ACCESS_TOKEN, null)
        }
        return currentToken
    }

    fun saveToken(tokenResponse: TokenResponse) {
        val expiresAt = System.currentTimeMillis() + 30 * 60 * 1000
        sharedPreferences.edit {
            putString(KEY_ACCESS_TOKEN, "Bearer ${tokenResponse.accessToken}")
            putLong(KEY_EXPIRES_AT, expiresAt)
        }

        currentToken = "Bearer ${tokenResponse.accessToken}"

    }

    fun isTokenExpired(): Boolean {
        val expiresAt = sharedPreferences.getLong(KEY_EXPIRES_AT, 0)
        return System.currentTimeMillis() > (expiresAt - TOKEN_EXPIRY_BUFFER)
    }

    fun clearToken() {
        sharedPreferences.edit {
            remove(KEY_ACCESS_TOKEN)
            remove(KEY_EXPIRES_AT)
        }
        currentToken = null
    }

}