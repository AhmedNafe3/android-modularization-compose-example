package com.jiftun.catalog.meals

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val mealsScreenRoute = "mealsScreenRoute/{categoryName}"

fun NavController.navigateToMealScreen(categoryName: String) {
    navigate("mealsScreenRoute/${categoryName}")
}

fun NavGraphBuilder.mealScreen(navController: NavHostController) {
    composable(
        route = mealsScreenRoute,
        arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
    ) {
        MealsRoute()
    }
}