package com.example.friendbook.data.service

import com.example.friendbook.data.entity.ChatRequest
import com.example.friendbook.data.entity.ChatResponse
import com.example.friendbook.data.entity.TokenResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.UUID

interface GigaChatApi {

    @POST("api/v2/oauth")
    @FormUrlEncoded
    suspend fun getToken(
        @Header("Authorization") authorization: String,
        @Header("Content-Type") contentType: String = "application/x-www-form-urlencoded",
        @Header("Accept") accept: String = "application/json",
        @Header("RqUID") rqUid: String = generateRqUID(),
        @Field("scope") scope: String = "GIGACHAT_API_PERS"
    ): TokenResponse

    @POST("api/v1/chat/completions")
    suspend fun sendMessage(
        @Header("Authorization") authorization: String,
        @Body request: ChatRequest
    ): ChatResponse

}

private fun generateRqUID(): String {
    return UUID.randomUUID().toString()
}