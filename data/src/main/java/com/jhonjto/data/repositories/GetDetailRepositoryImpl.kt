package com.jhonjto.data.repositories

import com.jhonjto.data.service.source.RemoteDataSource
import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 25/07/2021
 */
class GetDetailRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : GetDetailsRepository {

    override suspend fun getDetails(id: String): List<DetailItem> {
        return remoteDataSource.getDetails(id).data.let {
            return@let it!!
        }
    }
}
