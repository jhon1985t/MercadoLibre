package com.jhonjto

import android.app.Application
import com.jhonjto.data.repositories.GetDetailRepositoryImpl
import com.jhonjto.data.repositories.GetDetailsRepository
import com.jhonjto.data.repositories.SearchProductsRepository
import com.jhonjto.data.repositories.SearchProductsRepositoryImpl
import com.jhonjto.data.service.api.ApiClient
import com.jhonjto.data.service.source.RemoteDataSource
import com.jhonjto.data.service.source.RetrofitDataSource
import com.jhonjto.interactors.GetDetails
import com.jhonjto.interactors.GetListSearchProducts
import com.jhonjto.mercadolibre.fragments.DetailsFragment
import com.jhonjto.mercadolibre.fragments.SearchFragment
import com.jhonjto.mercadolibre.viewModels.SearchViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by jhon on 23/07/2021
 */

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        androidFileProperties()
        koin.loadModules(listOf(appModule, dataModule, scopesModule))
        koin.createRootScope()
    }
}

private val appModule = module {
    single { ApiClient.mercadoLibreServices }
    single<CoroutineDispatcher> { Dispatchers.Main }
    factory<RemoteDataSource> { RetrofitDataSource(get()) }
}

private val dataModule = module {
    factory<SearchProductsRepository> { SearchProductsRepositoryImpl(get()) }
    factory<GetDetailsRepository> { GetDetailRepositoryImpl(get()) }
}

private val scopesModule = module {
    scope(named<SearchFragment>()) {
        viewModel { SearchViewModel(get(), get(), get()) }
        scoped { GetListSearchProducts(get()) }
        scoped { GetDetails(get()) }
    }

    scope(named<DetailsFragment>()) {
        viewModel { SearchViewModel(get(), get(), get()) }
        scoped { GetListSearchProducts(get()) }
        scoped { GetDetails(get()) }
    }
}
