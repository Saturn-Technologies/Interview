package com.example.saturninterview.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

private const val BASE_URL =
    "https://dog.ceo/api/"

interface ExampleApiService

object ExampleAPI {
    private val retrofit =
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
    val retrofitService: ExampleApiService by lazy {
        retrofit.create(ExampleApiService::class.java)
    }
}
