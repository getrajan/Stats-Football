package com.Stats.Football.presentation.more_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Stats.Football.domain.model.PlayerInfo
import com.Stats.Football.domain.model.toPlayerInfo
import com.Stats.Football.presentation.more_info.component.MoreInfoAppBar
import com.Stats.Football.presentation.ui.theme.CustomTypography

@Composable
fun MoreInfoScreen(
    navController: NavController,
    moreInfoViewModel: MoreInfoViewModel
) {
    Scaffold(topBar = { MoreInfoAppBar(navController = navController) }) {
        val state = moreInfoViewModel.state.value

        Box(modifier = Modifier.fillMaxSize()) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                state.error.isNotBlank() -> {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                else -> {
                    val playerInfoList: List<PlayerInfo> = state.infoList
                    if (playerInfoList.isNotEmpty()) {
                        val playerInfo = playerInfoList.toPlayerInfo()
                        val detailItemList: ArrayList<String> = arrayListOf()
                        detailItemList.add("Goals: ${playerInfo.goals}")
                        detailItemList.add("Assists: ${playerInfo.assists}")
                        detailItemList.add("Yellow Cards: ${playerInfo.yellowCard}")
                        detailItemList.add("Red Cards: ${playerInfo.redCard}")
                        detailItemList.add("Shots on goal: ${playerInfo.shots_on_goal}")
                        detailItemList.add("Blocked shoots: ${playerInfo.blockedShots}")
                        detailItemList.add("Corners: ${playerInfo.corner}")
                        detailItemList.add("Offsides: ${playerInfo.offside}")

                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(detailItemList) { item ->
                                Column {
                                    Box(modifier = Modifier.fillMaxWidth()) {
                                        Text(
                                            text = item,
                                            modifier = Modifier.padding(12.dp),
                                            style = CustomTypography.playerNameStyle,
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(1.dp)
                                            .background(Color(0xFFBBBBBB))
                                    )
                                }
                            }
                        }
                    } else {
                        Text(
                            text = "No more info found",
                            color = MaterialTheme.colors.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(Alignment.Center)
                        )
                    }

                }
            }
        }
    }
}