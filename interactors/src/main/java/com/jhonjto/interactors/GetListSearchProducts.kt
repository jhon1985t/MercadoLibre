package com.jhonjto.interactors

import com.jhonjto.data.repositories.SearchProductsRepository
import com.jhonjto.domain.Result

/**
 * Created by jhon on 23/07/2021
 */
class GetListSearchProducts(
    private val searchProductsRepository: SearchProductsRepository
) {
    suspend fun invoke(products: String) : List<Result> =
        searchProductsRepository.listSearchProducts(products)
}
