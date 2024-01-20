package org.shop.app.domain.repository

import org.shop.app.data.model.Products

interface ShopApi {
    suspend fun getProducts(): Products
}