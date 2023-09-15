package com.sshen.myapplication.feature.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sshen.myapplication.feature.model.ItemResponse
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun DetailScreen(meal: ItemResponse?){
    Column() {
        Image(
            painter = rememberImagePainter(meal?.imageUrl?:""),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(4.dp)
                .align(Alignment.CenterHorizontally)
        )
        Box (modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center){
            Text(meal?.name ?: "",
                style = MaterialTheme.typography.headlineLarge,
            )
        }
        Box(modifier = Modifier.padding(16.dp) ) {
            Text(meal?.description ?: "",
                style = MaterialTheme.typography.bodyMedium)
        }



    }
}