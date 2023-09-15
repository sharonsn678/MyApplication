package com.sshen.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sshen.myapplication.feature.screen.DetailScreen
import com.sshen.myapplication.feature.screen.HomeScreen
import com.sshen.myapplication.feature.viewModel.DetailViewModel
import com.sshen.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen" ){
        composable(route = "HomeScreen"){
            HomeScreen(){ navigationItemId -> navController.navigate("DetailScreen/$navigationItemId")}
        }
        composable(route = "DetailScreen/{meal_id}",
            arguments = listOf(navArgument("meal_id"){
            type = NavType.StringType
        })){
            val dataModel : DetailViewModel = viewModel()
            DetailScreen(dataModel.mealState.value)
        }
    }
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

