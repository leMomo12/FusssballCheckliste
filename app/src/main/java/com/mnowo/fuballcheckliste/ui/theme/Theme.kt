package com.mnowo.fuballcheckliste.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = LightGreen,
    primaryVariant = LightBlue,
    secondary = NormalBlue,
    background = darkerWhite,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White


    /* Other default colors to override
    surface = Color.White,
    onSurface = Color.Black,
    */
)

@Composable
fun FußballChecklisteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
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