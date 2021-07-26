package com.jhonjto.data.service.source

import com.jhonjto.data.common.Resource
import com.jhonjto.domain.Result
import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 23/07/2021
 */
interface RemoteDataSource {

    suspend fun listSearchProducts(product: String) : Resource<List<Result>>
    suspend fun getDetails(id: String) : Resource<List<DetailItem>>
}
