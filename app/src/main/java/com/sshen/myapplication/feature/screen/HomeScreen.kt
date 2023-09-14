package com.sshen.myapplication.feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sshen.myapplication.feature.model.ItemResponse
import androidx.compose.material3.Text
import com.sshen.myapplication.feature.viewModel.HomeViewModel
import coil.compose.rememberImagePainter
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.shadow

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel.HomeViewModel = viewModel()
    val meals = viewModel.itemsState.value
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MyItemCategory(meal)
        }
    }
//    Text(text = "Home Screen")
}

@Composable
fun MyItemCategory(meal: ItemResponse) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .shadow(elevation = 2.dp)
    ) {
        Row {
            Image(
                painter = rememberImagePainter(meal.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}