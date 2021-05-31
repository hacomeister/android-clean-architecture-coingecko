package com.hacomeister.core.data.api

import com.hacomeister.core.domain.model.CoinEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service and Endpoints
 */
interface ApiService {

    @GET("coins/markets")
    suspend fun getAllCoinsFirst100(
        @Query("vs_currency") vs_currency: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 3,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): List<CoinEntity>

}