package org.shop.app.domain.repository

import org.shop.app.data.model.ProductsItem

interface ShopApi {
    suspend fun getProducts(): List<ProductsItem>
}