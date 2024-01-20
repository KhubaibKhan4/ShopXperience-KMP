package org.shop.app.domain.usecase

import org.shop.app.data.model.Products

sealed class ResultState {
    object LOADING: ResultState()
    data class SUCCESS(val products: Products): ResultState()
    data class ERROR(val error: String): ResultState()
}