package com.mnowo.fuballcheckliste.util

sealed class Screen(val route: String) {
    object SplashScreen: Screen("SplashScreen")
    object HomeScreen: Screen("HomeScreen")

}
