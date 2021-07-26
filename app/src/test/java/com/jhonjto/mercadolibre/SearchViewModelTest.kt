package com.jhonjto.mercadolibre

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jhonjto.data.common.Resource
import com.jhonjto.domain.Result
import com.jhonjto.interactors.GetDetails
import com.jhonjto.interactors.GetListSearchProducts
import com.jhonjto.mercadolibre.viewModels.SearchUiModel
import com.jhonjto.mercadolibre.viewModels.SearchViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by jhon on 26/07/2021
 */
@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var getListSearchProducts: GetListSearchProducts

    @MockK
    lateinit var getDetails: GetDetails

    @MockK
    lateinit var observer: Observer<SearchUiModel>

    private lateinit var searchViewModel: SearchViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        searchViewModel =
            SearchViewModel(
                getListSearchProducts,
                getDetails,
                Dispatchers.Unconfined
            )
    }

    @Test
    fun `load data from search`() = runBlocking {
        val result = mockk<List<Result>>()

        coEvery { getListSearchProducts.invoke(any()) } returns result

        searchViewModel.model.observeForever(observer)

        coVerify { observer.onChanged(SearchUiModel.Loading) }
        coVerify { observer.onChanged(SearchUiModel.Content(result)) }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}