package com.hacomeister.trackfavouritecoin.repository

import com.hacomeister.core.data.api.ApiService
import com.hacomeister.core.data.datasource.CoinDataSource
import com.hacomeister.core.domain.model.CoinEntity

/**
 * Implementation class of coin data source
 */
class CoinDataSource(private val apiService: ApiService) : CoinDataSource {

    override suspend fun getAll(): List<CoinEntity> {
        return apiService.getAllCoinsFirst100()
    }
}