package com.capstone.maggotin.data.remote.retrofit

import com.capstone.maggotin.data.remote.response.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // Endpoint untuk mendapatkan artikel
    @GET("articles")
    fun getArticles(): Call<ArticleResponse>
}