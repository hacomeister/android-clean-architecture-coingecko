package com.hacomeister.core.domain.repository

import com.hacomeister.core.domain.model.CoinEntity

interface ICoinRepository {
    suspend fun getAll(): List<CoinEntity>
}