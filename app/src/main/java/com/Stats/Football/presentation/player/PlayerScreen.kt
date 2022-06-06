package com.Stats.Football.presentation.player

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.Stats.Football.R
import com.Stats.Football.common.Constants
import com.Stats.Football.domain.model.SquadMember
import com.Stats.Football.presentation.Screen
import com.Stats.Football.presentation.more_info.MoreInfoViewModel
import com.Stats.Football.presentation.player.component.PlayerScreenAppBar
import com.Stats.Football.presentation.ui.theme.CustomTypography
import com.Stats.Football.presentation.ui.theme.GrayColor
import com.Stats.Football.presentation.ui.theme.YellowColor
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun PlayerScreen(
    navController: NavController,
    playerViewModel: PlayerViewModel,
    moreInfoViewModel: MoreInfoViewModel,
) {
    val player: SquadMember? = playerViewModel.player.value
    Scaffold(
        topBar = {
            PlayerScreenAppBar(navController = navController)
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp, horizontal = 40.dp)
                    .clip(shape = RoundedCornerShape(0.dp))
                    .background(YellowColor)
                    .clickable {
                        if (player != null) {
                            moreInfoViewModel.setPlayer(player)
                            navController.navigate(Screen.MoreInfoScreen.route)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "More Info",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1.copy(color = Color.Black)
                )
            }
        }
    ) {

        val detailItemList: ArrayList<String> = arrayListOf()

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        if (player != null) {
            val height =
                if (player.height == Constants.na) player.height else (df.format((player.height.toDouble() / 100))).toString()
            detailItemList.add("Date birthday: ${player.birthdate}")
            detailItemList.add("Position: ${player.position}")
            detailItemList.add("Height: $height m")
            detailItemList.add("Weight: ${player.weight} kg")
            detailItemList.add("Main Leg: ${player.foot}")
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn() {
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp)
                        ) {
                            Card(
                                shape = RoundedCornerShape(8.dp),
                                backgroundColor = Color(0xFF303030)
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://spoyer.com/api/team_img/soccer/${playerViewModel.teamPhotoUrl.value}.png")
                                        .crossfade(true)
                                        .build(),
                                    placeholder = painterResource(id = R.drawable.ic_photo),
                                    error = painterResource(id = R.drawable.ic_data_not_found),
                                    contentDescription = "Team Image",
                                    modifier = Modifier
                                        .height(65.dp)
                                        .width(76.dp)
                                        .padding(8.dp),
                                    contentScale = ContentScale.Fit,
                                )
                            }
                            Text(
                                text = player.name,
                                modifier = Modifier.padding(10.dp),
                                style = CustomTypography.teamNameStyle
                            )
                        }
                    }
                    items(detailItemList) { item ->
                        Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .background(Color(0xFF252525))
                            ) {
                                Text(
                                    text = item,
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


