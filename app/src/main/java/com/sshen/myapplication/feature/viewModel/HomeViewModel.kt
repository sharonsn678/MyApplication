package com.sshen.myapplication.feature.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sshen.myapplication.feature.model.ItemResponse
import com.sshen.myapplication.feature.repository.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel {
    class HomeViewModel (private val repository: ItemsRepository = ItemsRepository()): ViewModel() {

        init {
            viewModelScope.launch(Dispatchers.IO) {
                val meals = getItems()
                itemsState.value = meals
            }
        }

        val itemsState: MutableState<List<ItemResponse>> = mutableStateOf(emptyList<ItemResponse>())

        private suspend fun getItems(): List<ItemResponse> {
            return repository.getItems().categories
        }
    }
}