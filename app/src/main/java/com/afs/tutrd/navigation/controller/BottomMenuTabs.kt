package com.afs.tutrd.navigation.controller

import com.afs.tutrd.navigation.profile.screen.Profile
import androidx.annotation.DrawableRes
import com.afs.tutrd.R
import com.afs.tutrd.navigation.home.screen.Home

// FIXME ui fix 되면 메뉴 추가
enum class BottomMenuTabs(
    val qualifierName: String,
    @DrawableRes val iconId: Int,
    val label: String,
) {
    HOME(
        qualifierName = Home::class.java.name,
        iconId = R.drawable.ic_launcher_foreground, // FIXME ui fix 되면 Icon 변경
        label = "home"
    ),
    PROFILE(
        qualifierName = Profile::class.java.name,
        iconId = R.drawable.ic_launcher_foreground, // FIXME ui fix 되면 Icon 변경
        label = "profile"
    ),
}