package com.Stats.Football.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.Stats.Football.R
import com.Stats.Football.presentation.Screen

@Composable
fun SplashScreen(navController: NavController) {
    Scaffold(backgroundColor = Color.Red) {
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "Sport Stat Splash",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    enabled = true, onClickLabel = "Splash Image Clickable",
                    onClick = {
                        navController.navigate(Screen.MatchesScreen.route) {
                            popUpTo(0)
                        }
                    },
                )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashScreen(rememberNavController())
}