package com.afs.tutrd.theme

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.afs.tutrd.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TutrdTheme(
    content: @Composable () -> Unit
) {

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }
    CompositionLocalProvider(
        LocalRippleTheme provides NoRippleTheme,
        LocalOverscrollConfiguration provides null,
    ) {
        MaterialTheme(
            content = content
        )
    }
}

// no ripple
object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        draggedAlpha = 0f,
        focusedAlpha = 0f,
        hoveredAlpha = 0f,
        pressedAlpha = 0f,
    )
}


val Heading1 = TextStyle(
//    fontFamily = AppleSDGothicNeo,
    fontWeight = FontWeight.Bold,
//    color = TextColor,
    fontSize = 22.sp,
    lineHeight = 22.sp,
//    letterSpacing = LetterSpacing,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)