package com.jhonjto.data.service.source

import com.jhonjto.data.ResponseHandler
import com.jhonjto.data.common.Resource
import com.jhonjto.data.mapper.toDomainDetail
import com.jhonjto.data.mapper.toDomainResult
import com.jhonjto.data.service.MercadoLibreServices
import com.jhonjto.domain.Result
import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 23/07/2021
 */
class RetrofitDataSource(
    private val mercadoLibreServices: MercadoLibreServices
) : RemoteDataSource {

    override suspend fun listSearchProducts(product: String): Resource<List<Result>> {
        return try {
            val products = mercadoLibreServices.searchProduct(
                "MLA",
                product = product
            ).run {
                results?.map {
                    it.toDomainResult()
                }
            }
            ResponseHandler().handleSuccess(products!!)
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }

    override suspend fun getDetails(id: String): Resource<List<DetailItem>> {
        return try {
            val details = mercadoLibreServices.getDetails(
                item_id = id,
                attributes = "",
                id = "id",
                price = "price",
                condition = "condition",
                warranty = "warranty",
                title = "title",
                thumbnail = "thumbnail"
            ).map {
                it.toDomainDetail()
            }
            ResponseHandler().handleSuccess(details)
        } catch (e: Exception) {
            ResponseHandler().handleException(e)
        }
    }
}
