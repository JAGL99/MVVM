package com.jagl.mvvm.domain

import com.jagl.mvvm.data.QuoteRepository
import com.jagl.mvvm.data.model.QuoteModel
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}