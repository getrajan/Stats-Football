package com.Stats.Football.presentation.match.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.Stats.Football.R
import com.Stats.Football.domain.model.MatchModel
import com.Stats.Football.presentation.ui.theme.CustomTypography

@Composable
fun TeamsImageComponent(match: MatchModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color(0xFF303030)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://spoyer.com/api/team_img/soccer/${match.home.id}.png")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.ic_photo),
                    error = painterResource(id = R.drawable.ic_data_not_found),
                    contentDescription = "Team 1 Image",
                    modifier = Modifier
                        .height(65.dp)
                        .width(76.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
            }
            Text(
                text = match.home.name,
                style = CustomTypography.teamNameStyle,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)

        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color(0xFF303030)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://spoyer.com/api/team_img/soccer/${match.away.id}.png")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.ic_photo),
                    error = painterResource(id = R.drawable.ic_data_not_found),
                    contentDescription = "Team 1 Image",
                    modifier = Modifier
                        .height(65.dp)
                        .width(76.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
            }


            Text(
                text = match.away.name,
                style = CustomTypography.teamNameStyle,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}