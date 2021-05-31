package com.hacomeister.trackfavouritecoin

import android.app.Application
import com.hacomeister.core.data.CoinRepository
import com.hacomeister.core.data.api.ApiService
import com.hacomeister.core.domain.usecases.GetAllCoinsUseCase
import com.hacomeister.trackfavouritecoin.repository.CoinDataSource
import com.hacomeister.trackfavouritecoin.util.Constant
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TFCApplication : Application() {

    @ExperimentalSerializationApi
    override fun onCreate() {
        super.onCreate()

        val contentType = "application/json"

        val json = Json {
            ignoreUnknownKeys = true
        }

        val apiService = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Json.asConverterFactory(contentType)
            .build().create(ApiService::class.java)

        val coinRepository = CoinRepository(CoinDataSource(apiService))

        TFCViewModelFactory.inject(
            this,
            UseCases(
                GetAllCoinsUseCase(coinRepository = coinRepository)
            )
        )
    }
}