package com.hacomeister.core.domain.util

import org.jetbrains.annotations.Nullable

abstract class BaseUseCase<Model, Params> {
    abstract suspend fun buildRequest(@Nullable params: Params?): Model?

    suspend fun execute(@Nullable params: Params?): Model? {
        return try {
            buildRequest(params)
        } catch (exception: Exception) {
            null
        }
    }
}