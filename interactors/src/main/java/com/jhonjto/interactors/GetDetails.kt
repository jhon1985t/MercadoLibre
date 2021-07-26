package com.jhonjto.interactors

import com.jhonjto.data.repositories.GetDetailsRepository
import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 25/07/2021
 */
class GetDetails(
    private val getDetailsRepository: GetDetailsRepository
) {
    suspend fun invoke(id: String) : List<DetailItem> =
        getDetailsRepository.getDetails(id)
}
