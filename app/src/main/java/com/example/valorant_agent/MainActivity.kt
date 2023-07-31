package com.example.valorant_agent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.valorant_agent.ui.navigation.Screen
import com.example.valorant_agent.ui.screens.AboutScreen
import com.example.valorant_agent.ui.screens.DetailScreen
import com.example.valorant_agent.ui.screens.HomeScreen
import com.example.valorant_agent.ui.theme.ValorantAgentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAgentTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ValorantApp()
                }
            }
        }
    }
}

@Composable
fun ValorantApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(modifier = Modifier, navController = navController)
        }
        composable(Screen.Profile.route) {
            AboutScreen(modifier = Modifier, onBackPressed = {
                navController.popBackStack()
            })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("index") { type = NavType.IntType }),
        ) {
            val index = it.arguments?.getInt("index") ?: -1
            DetailScreen(
                modifier = Modifier,
                index = index,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}