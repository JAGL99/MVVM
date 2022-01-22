package com.jagl.mvvm.domain

import com.jagl.mvvm.data.QuoteRepository
import com.jagl.mvvm.data.model.QuoteModel
import com.jagl.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val respository: QuoteRepository
){

    suspend operator fun invoke(): Quote?{
        val quotes = respository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}