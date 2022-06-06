package com.Stats.Football.presentation.match.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Stats.Football.presentation.Screen
import com.Stats.Football.presentation.match.MatchViewModel
import com.Stats.Football.presentation.player.PlayerViewModel
import com.Stats.Football.presentation.ui.theme.CustomTypography
import com.Stats.Football.presentation.ui.theme.GrayColor

@Composable
fun SquadMemberComponent(
    matchViewModel: MatchViewModel,
    navController: NavController,
    playerViewModel: PlayerViewModel
) {
    val squadState = matchViewModel.squadMemberListState.value
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            squadState.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            squadState.error.isNotBlank() -> {
                Text(
                    text = squadState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            else -> {
                if (squadState.squadMemberList.isEmpty()) {
                    Text(
                        text = "No Team Squad Members",
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(squadState.squadMemberList) { squadMember ->
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Box(modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .background(Color(0xFF252525))
                                .clickable {
                                    playerViewModel.setPlayer(squadMember)
                                    playerViewModel.setTeamPhotoUrl(
                                        matchViewModel.teamPhotoUrl.value ?: ""
                                    )
                                    navController.navigate(Screen.PlayerScreen.route)
                                }
                            ) {
                                Text(
                                    text = squadMember.name,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    style = CustomTypography.playerNameStyle,
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(GrayColor)
                            )
                        }
                    }
                }
            }
        }
    }
}