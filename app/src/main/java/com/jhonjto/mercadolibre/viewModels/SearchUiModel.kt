package com.jhonjto.mercadolibre.viewModels

import com.jhonjto.domain.Result
import com.jhonjto.domain.detail.DetailItem

/**
 * Created by jhon on 23/07/2021
 */
sealed class SearchUiModel {
    object Loading :  SearchUiModel()
    data class Content(val products: List<Result>) : SearchUiModel()
    data class Detail(val details: List<DetailItem>) : SearchUiModel()
    data class GenericError(val message: String) : SearchUiModel()
}
