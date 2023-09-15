package com.sshen.myapplication.feature.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sshen.myapplication.feature.model.ItemResponse
import com.sshen.myapplication.feature.repository.ItemsRepository

class DetailViewModel(private  val savedStateHandle: SavedStateHandle
                      ):ViewModel()
{
    var mealState = mutableStateOf<ItemResponse?>(null)
    private var repository :ItemsRepository = ItemsRepository.getInstance()

    init{
        val mealId = savedStateHandle.get<String>("meal_id") ?: ""
        mealState.value = repository.getItem(mealId)
    }
}