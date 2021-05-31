package com.hacomeister.core.data.datasource

import com.hacomeister.core.domain.model.CoinEntity

interface CoinDataSource {
    suspend fun getAll(): List<CoinEntity>
}