package com.jagl.mvvm.domain

import com.jagl.mvvm.data.model.QuoteModel
import com.jagl.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider:QuoteProvider
){

    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}