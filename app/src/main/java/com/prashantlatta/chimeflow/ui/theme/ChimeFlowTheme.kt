package com.prashantlatta.chimeflow.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFA88D62),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF766548),
    background = Color(0xFFF3EFE5),
    onBackground = Color(0xFF35342F),
    surface = Color(0xFFF5F1E8),
    onSurface = Color(0xFF35342F),
    surfaceVariant = Color(0xFFECE6D9),
    onSurfaceVariant = Color(0xFF898477)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFD6B56D),
    onPrimary = Color(0xFF211A0B),
    secondary = Color(0xFFBCA16A),
    background = Color(0xFF000000),
    onBackground = Color(0xFFF2F0EB),
    surface = Color(0xFF080808),
    onSurface = Color(0xFFF2F0EB),
    surfaceVariant = Color(0xFF101010),
    onSurfaceVariant = Color(0xFF898989)
)

@Composable
fun ChimeFlowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}
