package com.hacomeister.core.domain.usecases

import com.hacomeister.core.domain.model.CoinEntity
import com.hacomeister.core.domain.util.BaseUseCase
import com.hacomeister.core.domain.repository.ICoinRepository

class GetAllCoinsUseCase(val coinRepository: ICoinRepository) :
    BaseUseCase<List<CoinEntity>, Nothing>() {

    override suspend fun buildRequest(params: Nothing?): List<CoinEntity> {

        return coinRepository.getAll()

    }
}