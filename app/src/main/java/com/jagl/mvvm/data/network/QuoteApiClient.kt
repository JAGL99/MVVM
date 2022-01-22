package com.jagl.mvvm.data.network

import com.jagl.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}