package com.sshen.myapplication.feature.repository

import com.sshen.myapplication.feature.api.ItemWebService
import com.sshen.myapplication.feature.model.CategoriesResponse

class ItemsRepository(private val webService: ItemWebService = ItemWebService()) {
    suspend fun getItems(): CategoriesResponse {
        return webService.getItems()
    }
}