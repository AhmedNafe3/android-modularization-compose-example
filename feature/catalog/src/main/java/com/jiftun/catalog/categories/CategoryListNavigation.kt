package com.jiftun.catalog.categories

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


const val categoryListScreenRoute = "categoryListScreenRoute"

fun NavGraphBuilder.categoryScreen(navController: NavHostController) {
    composable(
        route = categoryListScreenRoute
    ) {

        CategoryListRoute(
            navController = navController
        )
    }
}