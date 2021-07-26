package com.jhonjto.mercadolibre

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.jhonjto.data.service.MercadoLibreServices
import com.jhonjto.data.service.response.JobResponse
import com.jhonjto.data.service.response.detail.DetailResponse
import com.jhonjto.data.service.source.RetrofitDataSource
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by jhon on 26/07/2021
 */
@RunWith(MockitoJUnitRunner::class)
class RetrofitDataSourceTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var mercadoLibreServices: MercadoLibreServices

    private lateinit var retrofitDataSource: RetrofitDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        retrofitDataSource = RetrofitDataSource(mercadoLibreServices)
    }

    @Test
    fun `test service consume with result listSearchProducts`() = runBlocking {
        val jobResponse = mockk<JobResponse>()

        coEvery {
            mercadoLibreServices.searchProduct(any(), any())
        } returns jobResponse

        val result = mercadoLibreServices.searchProduct("CO", "SONY")

        coVerify { mercadoLibreServices.searchProduct(any(), any()) }
        assertEquals(jobResponse, result)
    }

    @Test
    fun `test service consume with result getDetails`() = runBlocking {
        val detailResponse = mockk<DetailResponse>()

        coEvery {
            mercadoLibreServices.getDetails(any(), any(), any(), any(), any(), any(), any(), any())
        } returns detailResponse

        val result = mercadoLibreServices.getDetails(
            "MAL000123",
            "",
            "1",
            "12000",
            "new",
            "12 months",
            "sony",
            "https://www.image.com"
        )

        coVerify { mercadoLibreServices.getDetails(any(), any(), any(), any(), any(), any(), any(), any()) }
        assertEquals(detailResponse, result)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}
