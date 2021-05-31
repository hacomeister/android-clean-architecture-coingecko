package com.hacomeister.trackfavouritecoin.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hacomeister.core.domain.model.CoinEntity
import com.hacomeister.trackfavouritecoin.UseCases
import com.hacomeister.trackfavouritecoin.base.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShowAllCoinsViewModel(application: Application, useCases: UseCases) :
    BaseViewModel(application, useCases) {


    private val _coins: MutableLiveData<List<CoinEntity>> = MutableLiveData()
    val coins: LiveData<List<CoinEntity>> = _coins

    fun getAllCoins() {
        GlobalScope.launch {
            useCases.getAllCoinsUseCase.execute(null).let {
                _coins.postValue(it)
            }
        }
    }
}