package com.jagl.mvvm.domain.model

import com.jagl.mvvm.data.database.entities.QuoteEntity
import com.jagl.mvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)