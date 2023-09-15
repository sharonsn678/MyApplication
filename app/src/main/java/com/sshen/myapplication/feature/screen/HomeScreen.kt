package com.sshen.myapplication.feature.screen


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.ComposeNodeLifecycleCallback
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun HomeScreen(navigationCallback: (String) -> Unit) {
    val viewModel: HomeViewModel.HomeViewModel = viewModel()
    val meals = viewModel.itemsState.value
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MyItemCategory(meal, navigationCallback = navigationCallback)
        }
    }
//    Text(text = "Home Screen")
}

@Composable
fun MyItemCategory(meal: ItemResponse, navigationCallback: (String)->Unit) {
var isExpanded by remember { mutableStateOf(false)}

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .shadow(elevation = 2.dp)
            .clickable { navigationCallback(meal.id) }
    ) {
        Row (Modifier.animateContentSize()){
            Image(
                painter = rememberImagePainter(meal.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = meal.description,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded)
                            40
                        else
                            10
                )
            }
            Icon(imageVector =  if (isExpanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand row icon",
                modifier = Modifier
                    .padding(2.dp)
                    .clickable { isExpanded = !isExpanded }
                    .align(
                        alignment = if (isExpanded)
                            Alignment.Bottom
                        else
                            Alignment.CenterVertically
                    )
            )
        }
    }
}