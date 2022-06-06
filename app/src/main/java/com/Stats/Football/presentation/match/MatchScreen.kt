package com.Stats.Football.presentation.match

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Stats.Football.domain.model.MatchModel
import com.Stats.Football.presentation.match.component.*
import com.Stats.Football.presentation.player.PlayerViewModel

@Composable
fun MatchScreen(
    navController: NavController,
    matchViewModel: MatchViewModel,
    playerViewModel: PlayerViewModel,
) {
    Scaffold(topBar = {
        MatchAppBarComponent(navController = navController)
    }) {
        val match: MatchModel? = matchViewModel.targetedMatch.value
        if (match != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 0.dp, vertical = 12.dp),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    LeagueInfoComponent(match)
                    TeamsImageComponent(match)
                    Box(modifier = Modifier.height(24.dp))
                    TeamToggleComponent(matchViewModel)
                    Box(modifier = Modifier.height(6.dp))
                    SquadMemberComponent(matchViewModel, navController, playerViewModel)
                }
            }
        }
    }
}











