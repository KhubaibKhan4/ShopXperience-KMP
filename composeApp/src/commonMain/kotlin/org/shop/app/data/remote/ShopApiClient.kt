package org.shop.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.shop.app.data.model.ProductsItem
import org.shop.app.utils.Constant.BASE_URL
import org.shop.app.utils.Constant.TIMEOUT

object ShopApiClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT
            requestTimeoutMillis = TIMEOUT
            socketTimeoutMillis = TIMEOUT
        }
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
            sanitizeHeader { header ->
                header == HttpHeaders.Authorization
            }
        }
    }
    suspend fun getProducts(): List<ProductsItem>{
        val url= BASE_URL+"api/v1/products"
        return client.get(url).body()
    }
}