package com.jhonjto.data.repositories

import com.jhonjto.domain.Result

/**
 * Created by jhon on 23/07/2021
 */
interface SearchProductsRepository {
    suspend fun listSearchProducts(products: String) : List<Result>
}
