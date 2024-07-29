package com.akshat.udemycoursemovieapp.navigation

import android.health.connect.datatypes.ExerciseRoute

enum class MoviewScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?) : MoviewScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route is $route")
        }
    }
}