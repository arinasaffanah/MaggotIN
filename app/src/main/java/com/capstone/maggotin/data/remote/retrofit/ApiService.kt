package com.capstone.maggotin.data.remote.retrofit

import com.capstone.maggotin.data.remote.response.ArticleResponse
import com.capstone.maggotin.data.remote.response.RegisterRequest
import com.capstone.maggotin.data.remote.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("articles")
    fun getArticles(): Call<ArticleResponse>

    @Headers("Content-Type: application/json")
    @POST("users/register")
    suspend fun register(
        @Body requestBody: RegisterRequest
    ): RegisterResponse
}