package com.jhonjto.data.service

import com.jhonjto.data.service.response.JobResponse
import com.jhonjto.data.service.response.detail.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by jhon on 23/07/2021
 */
interface MercadoLibreServices {

    @GET("sites/{SITE_ID}/search")
    suspend fun searchProduct(
        @Path("SITE_ID") site_id: String,
        @Query("q") product: String
    ): JobResponse

    @GET("items")
    suspend fun getDetails(
        @Query("ids") item_id: String,
        @Query("attributes") attributes: String? = null,
        @Query("ATTRIBUTE1") id: String,
        @Query("ATTRIBUTE2") price: String,
        @Query("ATTRIBUTE3") condition: String,
        @Query("ATTRIBUTE4") warranty: String,
        @Query("ATTRIBUTE5") title: String,
        @Query("ATTRIBUTE6") thumbnail: String,
    ): DetailResponse
}
