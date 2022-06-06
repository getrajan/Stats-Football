package com.Stats.Football.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.Stats.Football.presentation.Screen
import com.Stats.Football.presentation.match.MatchScreen
import com.Stats.Football.presentation.match.MatchViewModel
import com.Stats.Football.presentation.matches.MatchesScreen
import com.Stats.Football.presentation.more_info.MoreInfoScreen
import com.Stats.Football.presentation.more_info.MoreInfoViewModel
import com.Stats.Football.presentation.player.PlayerScreen
import com.Stats.Football.presentation.player.PlayerViewModel
import com.Stats.Football.presentation.splash.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    val matchViewModel: MatchViewModel = hiltViewModel()
    val playerViewModel: PlayerViewModel = hiltViewModel()
    val moreInfoViewModel: MoreInfoViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MatchesScreen.route) {
            MatchesScreen(navController, matchViewModel = matchViewModel)
        }
        composable(route = Screen.MatchScreen.route) {
            MatchScreen(navController, matchViewModel, playerViewModel)
        }
        composable(route = Screen.PlayerScreen.route) {
            PlayerScreen(
                navController,
                playerViewModel,
                moreInfoViewModel
            )
        }
        composable(route = Screen.MoreInfoScreen.route) {
            MoreInfoScreen(
                navController,
                moreInfoViewModel
            )
        }
    }

}