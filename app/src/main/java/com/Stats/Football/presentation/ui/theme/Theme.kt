package com.Stats.Football.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = GrayColor,
    primaryVariant = BlackGray,
    secondary = WhiteColor,
    background = Color(0xFF252525),
    onBackground = PrimaryBlackColor
)

private val LightColorPalette = lightColors(
    primary = GrayColor,
    primaryVariant = BlackGray,
    secondary = WhiteColor,
    background = Color(0xFF252525),
    onBackground = PrimaryBlackColor

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
//    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SportStatTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}