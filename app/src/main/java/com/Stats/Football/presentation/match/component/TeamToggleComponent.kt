package com.Stats.Football.presentation.match.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.Stats.Football.presentation.match.MatchViewModel
import com.Stats.Football.presentation.match.TeamEnum
import com.Stats.Football.presentation.ui.theme.WhiteColor
import com.Stats.Football.presentation.ui.theme.YellowColor

@Composable
fun TeamToggleComponent(matchViewModel: MatchViewModel) {
    val teamState = matchViewModel.teamState.value
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        matchViewModel.toggleTeams(TeamEnum.TEAM1)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Team 1",
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = if (teamState == TeamEnum.TEAM1) Color.Yellow else WhiteColor,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.W600
                    )
                )
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(if (teamState == TeamEnum.TEAM1) YellowColor else WhiteColor)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        matchViewModel.toggleTeams(TeamEnum.TEAM2)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Team 2",
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = if (teamState == TeamEnum.TEAM2) Color.Yellow else WhiteColor,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.W600
                    )
                )
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(if (teamState == TeamEnum.TEAM2) YellowColor else WhiteColor)
                )
            }
        }
    }
}