package com.jagl.mvvm.domain

import com.jagl.mvvm.data.QuoteRepository
import com.jagl.mvvm.data.database.entities.toDatabase
import com.jagl.mvvm.domain.model.Quote
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke(): List<Quote>?{
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}