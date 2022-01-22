package com.jagl.mvvm.data

import com.jagl.mvvm.data.model.QuoteModel
import com.jagl.mvvm.data.model.QuoteProvider
import com.jagl.mvvm.data.network.QuoteService
import javax.inject.Inject


class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
){

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }

}