package com.jiftun.talamobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jiftun.catalog.categories.categoryListScreenRoute
import com.jiftun.catalog.categories.categoryScreen
import com.jiftun.catalog.meals.mealScreen


@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = categoryListScreenRoute
) {
    NavHost(
        navController = navController, startDestination = startDestination, modifier = modifier
    ) {
        categoryScreen(navController)
        mealScreen(navController)
    }
}