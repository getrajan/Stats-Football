package com.Stats.Football.presentation.player.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Stats.Football.R
import com.Stats.Football.presentation.ui.theme.CustomTypography
import com.Stats.Football.presentation.ui.theme.GrayLightColor

@Composable
fun PlayerScreenAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Player",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp),
                style = CustomTypography.appBarTitleStyle
            )
        },
        backgroundColor = GrayLightColor,
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        navController.popBackStack()
                    },
            )
        }

    )
}