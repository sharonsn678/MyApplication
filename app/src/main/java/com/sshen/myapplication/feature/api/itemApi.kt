package com.sshen.myapplication.feature.api

import com.sshen.myapplication.feature.model.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ItemWebService {
    private var api: ItemApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ItemApi::class.java)
    }

    suspend fun getItems(): CategoriesResponse {
        return api.getItems()
    }

    interface ItemApi {
        @GET("/api/json/v1/1/categories.php")
        suspend fun getItems(): CategoriesResponse
    }
}