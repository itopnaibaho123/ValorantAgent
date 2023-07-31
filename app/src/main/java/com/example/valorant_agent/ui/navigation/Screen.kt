package com.example.valorant_agent.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("detail/{index}") {
        fun createRoute(index: Int) = "detail/$index"
    }
}