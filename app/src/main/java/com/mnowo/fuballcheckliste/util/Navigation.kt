package com.mnowo.fuballcheckliste.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mnowo.fuballcheckliste.presentation.HomeScreen.HomeScreen
import com.mnowo.fuballcheckliste.presentation.HomeScreen.HomeScreenViewModel
import com.mnowo.fuballcheckliste.presentation.SplashScreen.SplashScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navHostController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navHostController)
        }
        composable("TrainingListScreen") {

        }
        composable("GameListScreen") {

        }
    }
}