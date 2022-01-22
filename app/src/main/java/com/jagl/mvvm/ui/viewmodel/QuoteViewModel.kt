package com.jagl.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagl.mvvm.data.model.QuoteModel
import com.jagl.mvvm.data.model.QuoteProvider
import com.jagl.mvvm.domain.GetQuotesUseCase
import com.jagl.mvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel
    @Inject constructor(
        private val getQuotesUseCase: GetQuotesUseCase,
        private val getRandomQuoteUseCase: GetRandomQuoteUseCase
    ): ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()

    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    //       val currentQuote = QuoteProvider.getRandomQuote()
    //        quoteModel.postValue(currentQuote)
    }
}