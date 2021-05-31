package com.hacomeister.core.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinEntity(
    @SerialName("current_price")
    val current_price: Float?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("price_change_percentage_24h")
    val price_change_percentage_24h: Double?,
    @SerialName("symbol")
    val symbol: String?
)