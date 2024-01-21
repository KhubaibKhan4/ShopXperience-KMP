package org.shop.app.domain.repository

import org.shop.app.data.model.ProductsItem
import org.shop.app.data.remote.ShopApiClient

class Repository: ShopApi {
    override suspend fun getProducts(): List<ProductsItem> {
        return ShopApiClient.getProducts()
    }
}