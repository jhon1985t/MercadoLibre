package com.jhonjto.mercadolibre.scopes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by jhon on 23/07/2021
 */
abstract class ScopeViewModel(
    uiDispatcher: CoroutineDispatcher
) : ViewModel(), Scope by Scope.Impl(uiDispatcher) {

    init {
        createScope()
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}
