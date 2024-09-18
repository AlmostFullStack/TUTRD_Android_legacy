package com.afs.tutrd.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.afs.tutrd.R

// 타입 정의


private val Pretendard = FontFamily(
    Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_thin, FontWeight.Thin),
)

val MediumBody1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 18.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val MediumBody2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val MediumTitle1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val MediumTitle2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    lineHeight = 26.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val MediumTitle3 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val MediumAccent = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 28.sp,
    lineHeight = 38.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val SemiBoldBody1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    lineHeight = 18.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val SemiBoldBody2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val SemiBoldTitle1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val SemiBoldTitle2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
    lineHeight = 26.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)

val SemiBoldTitle3 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)


val SemiBoldAccent = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 28.sp,
    lineHeight = 38.sp,
    textAlign = TextAlign.Justify,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    )
)