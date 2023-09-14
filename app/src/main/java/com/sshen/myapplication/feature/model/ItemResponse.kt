package com.sshen.myapplication.feature.model

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(val categories:List<ItemResponse>)

data class ItemResponse(
    @SerializedName("idCategory")  val id: String,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryDescription")   val description: String,
    @SerializedName("strCategoryThumb")  val imageUrl:String
)