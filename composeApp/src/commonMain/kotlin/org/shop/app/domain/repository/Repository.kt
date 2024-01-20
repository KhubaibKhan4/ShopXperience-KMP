package org.shop.app.domain.repository

import org.shop.app.data.model.Products
import org.shop.app.data.remote.ShopApiClient

class Repository: ShopApi {
    override suspend fun getProducts(): Products {
        return ShopApiClient.getProducts()
    }
}