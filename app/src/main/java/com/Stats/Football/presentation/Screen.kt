package com.Stats.Football.presentation

sealed class Screen(val route: String, val name: String) {
    object SplashScreen : Screen(route = "splash_screen", name = "Splash")
    object MatchesScreen : Screen(route = "matches_screen", name = "Matches")
    object MatchScreen : Screen(route = "match_screen", name = "Match")
    object PlayerScreen : Screen(route = "player_screen", name = "Player")
    object MoreInfoScreen : Screen(route = "more_info_screen", name = "More Info")
}