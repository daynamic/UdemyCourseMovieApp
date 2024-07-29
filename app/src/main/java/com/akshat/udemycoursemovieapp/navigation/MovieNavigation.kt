package com.akshat.udemycoursemovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akshat.udemycoursemovieapp.screens.home.HomeScreen
import com.akshat.udemycoursemovieapp.screens.home.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MoviewScreens.HomeScreen.name){

        composable(MoviewScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(MoviewScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){backStackEntry ->
           DetailsScreen(navController = navController,
               backStackEntry.arguments?.getString("movie"))
        }
    }
}