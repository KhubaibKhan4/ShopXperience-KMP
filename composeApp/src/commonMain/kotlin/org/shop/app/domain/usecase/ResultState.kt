package org.shop.app.domain.usecase

import org.shop.app.data.model.ProductsItem

sealed class ResultState {
    object LOADING: ResultState()
    data class SUCCESS(val products: List<ProductsItem>): ResultState()
    data class ERROR(val error: String): ResultState()
}