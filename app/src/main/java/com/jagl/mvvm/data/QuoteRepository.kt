package com.jagl.mvvm.data

import com.jagl.mvvm.data.database.dao.QuoteDao
import com.jagl.mvvm.data.database.entities.QuoteEntity
import com.jagl.mvvm.data.network.QuoteService
import com.jagl.mvvm.domain.model.Quote
import com.jagl.mvvm.domain.model.toDomain
import javax.inject.Inject


class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
){

    suspend fun getAllQuotesFromApi(): List<Quote>{
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }

}