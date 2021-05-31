package com.hacomeister.core.data

import com.hacomeister.core.data.datasource.CoinDataSource
import com.hacomeister.core.domain.model.CoinEntity
import com.hacomeister.core.domain.repository.ICoinRepository

class CoinRepository(private val dataSource: CoinDataSource): ICoinRepository {

    override suspend fun getAll(): List<CoinEntity> {
        return dataSource.getAll()
    }

}