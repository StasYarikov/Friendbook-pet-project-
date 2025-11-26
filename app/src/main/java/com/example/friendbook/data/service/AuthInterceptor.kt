package com.example.friendbook.data.service

import android.util.Log
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val tokenManager: TokenManager,
    private val authApi: GigaChatApi,
    private val authKey: String
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()

        if (originalRequest.url.encodedPath.contains("oauth")) {
            return chain.proceed(originalRequest)
        }

        Log.e("Check_my_mistakes", "Have been here")
        var token = tokenManager.getToken()

        if (token == null || tokenManager.isTokenExpired()) {
            token = refreshToken()
            Log.e("Check_my_mistakes", "Have been here 1212 $token")
        }

        if (token == null) {
            return chain.proceed(originalRequest)
        }

        val authorizedRequest = originalRequest.newBuilder()
            .header("Authorization", token)
            .build()

        return chain.proceed(authorizedRequest)
    }

    private fun refreshToken(): String? {
        return try {
            val response = runBlocking {
                authApi.getToken("Basic $authKey")
            }
            Log.e("Check_my_mistakes", "Have been $response")
            tokenManager.saveToken(response)
            tokenManager.getToken()
        } catch (e: Exception) {
            Log.e("Check_my_mistakes", e.message!!)
            null
        }
    }

}