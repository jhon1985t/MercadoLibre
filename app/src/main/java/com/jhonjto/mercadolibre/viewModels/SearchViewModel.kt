package com.jhonjto.mercadolibre.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jhonjto.data.common.Resource
import com.jhonjto.data.common.Status
import com.jhonjto.domain.Result
import com.jhonjto.interactors.GetDetails
import com.jhonjto.interactors.GetListSearchProducts
import com.jhonjto.mercadolibre.scopes.ScopeViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * Created by jhon on 23/07/2021
 */
class SearchViewModel(
    private val getListSearchProducts: GetListSearchProducts,
    private val getDetails: GetDetails,
    uiDispatcher: CoroutineDispatcher
) : ScopeViewModel(uiDispatcher) {

    init {
        createScope()
    }

    private val _model = MutableLiveData<SearchUiModel>()
    val model: LiveData<SearchUiModel>
        get() {
            return _model
        }

    fun searchProducts(
        products: String
    ) {
        launch {
            _model.value = SearchUiModel.Loading
            _model.value = SearchUiModel.Content(getListSearchProducts.invoke(products))
        }
    }

    fun detailsProduct(
        id: String
    ) {
        launch {
            _model.value = SearchUiModel.Loading
            _model.value = SearchUiModel.Detail(getDetails.invoke(id))
        }
    }

    override fun onCleared() {
        super.onCleared()
        destroyScope()
    }
}
