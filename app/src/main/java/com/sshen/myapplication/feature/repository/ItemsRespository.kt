package com.sshen.myapplication.feature.repository

import com.sshen.myapplication.feature.api.ItemWebService
import com.sshen.myapplication.feature.model.CategoriesResponse
import com.sshen.myapplication.feature.model.ItemResponse

class ItemsRepository(private val webService: ItemWebService = ItemWebService()) {

    private var cachedItems = listOf<ItemResponse>()
    suspend fun getItems(): CategoriesResponse {
        val theResponse = webService.getItems()
        cachedItems = theResponse.categories
        return theResponse
    }

    fun getItem(id: String): ItemResponse?{
        return cachedItems.firstOrNull{
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: ItemsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: ItemsRepository().also { instance = it }
        }
    }
}