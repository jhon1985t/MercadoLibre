package com.jhonjto.data.service.api

import com.jhonjto.data.BuildConfig
import com.jhonjto.data.service.MercadoLibreServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by jhon on 23/07/2021
 */
object ApiClient {

    private fun addInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        return interceptor
    }

    private fun getHeaderInterceptor(): Interceptor {
        return object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val request =
                    chain.request().newBuilder()
                        .header("Content-Type", "application/json; charset=utf8")
                        .header("Accept", "application/json")
                        .build()
                return chain.proceed(request)
            }
        }
    }

    private fun retrofit() : Retrofit {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(addInterceptor())
            .connectTimeout(Constants.connectTimeout, TimeUnit.MINUTES)
            .readTimeout(Constants.readTimeOut, TimeUnit.SECONDS)
            .writeTimeout(Constants.writeTimeout, TimeUnit.SECONDS)
            .addNetworkInterceptor(getHeaderInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    val mercadoLibreServices: MercadoLibreServices by lazy {
        retrofit()
            .create(MercadoLibreServices::class.java)
    }
}
