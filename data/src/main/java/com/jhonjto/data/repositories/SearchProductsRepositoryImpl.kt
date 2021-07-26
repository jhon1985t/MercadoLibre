package com.jhonjto.data.repositories

import com.jhonjto.data.service.source.RemoteDataSource
import com.jhonjto.domain.Result

/**
 * Created by jhon on 23/07/2021
 */
class SearchProductsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : SearchProductsRepository {

    override suspend fun listSearchProducts(products: String): List<Result> {
        return remoteDataSource.listSearchProducts(products).data.let {
            return@let it!!
        }
    }
}
