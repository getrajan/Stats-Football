package com.Stats.Football.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.Stats.Football.R

val FiraSans = FontFamily(
    Font(R.font.fira_sans_regular, FontWeight.W400),
    Font(R.font.fira_sans_medium, FontWeight.W500),
    Font(R.font.fira_sans_semi_bold, FontWeight.W600),
    Font(R.font.fira_sans_bold, FontWeight.W700)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    h2 = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.W500,
        color = WhiteColor,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.W600,
        color = LightWhiteColor,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */

)

object CustomTypography {
    //appbar title style
    val appBarTitleStyle = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.W600,
        color = WhiteColor,
        fontSize = 18.sp
    )

    val teamNameStyle = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.W500,
        color = WhiteColor,
        fontSize = 18.sp
    )
    val playerNameStyle = TextStyle(
        fontFamily = FiraSans,
        fontWeight = FontWeight.W500,
        color = LightWhiteColor,
        fontSize = 14.sp
    )
}