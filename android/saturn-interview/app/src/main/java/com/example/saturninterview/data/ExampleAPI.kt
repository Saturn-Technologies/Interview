package com.example.saturninterview.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

interface ExampleApiService {
    @GET("photos")
    suspend fun getData(): List<Item>
}

@Serializable
data class Item(
    val id: String,
    @SerialName("img_src") val imgSrc: String
)

object ExampleAPI {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
    val retrofitService : ExampleApiService by lazy {
        retrofit.create(ExampleApiService::class.java)
    }
}

