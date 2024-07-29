package com.akshat.udemycoursemovieapp.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akshat.udemycoursemovieapp.MovieRow
import com.akshat.udemycoursemovieapp.navigation.MoviewScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Moviess")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Magenta
                )
            )
        }
    ) { it ->
        Surface(modifier = Modifier.padding(top = it.calculateTopPadding())) {
           // content()
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "Love",
        "Hate",
        "Avatar",
        "300",
        "Harry Potter"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        val context = LocalContext.current
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it){movie ->
                    Toast.makeText(context, "Clikced on $movie", Toast.LENGTH_SHORT).show()
                    navController.navigate(route = MoviewScreens.DetailsScreen.name)
                }
            }
        }

    }


}