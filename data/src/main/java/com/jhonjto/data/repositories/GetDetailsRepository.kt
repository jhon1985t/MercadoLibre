package com.jhonjto.data.repositories

import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 25/07/2021
 */
interface GetDetailsRepository {
    suspend fun getDetails(id: String) : List<DetailItem>
}
