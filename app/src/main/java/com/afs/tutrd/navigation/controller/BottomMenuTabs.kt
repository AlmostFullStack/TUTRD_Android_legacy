package com.afs.tutrd.navigation.controller

import com.afs.tutrd.navigation.profile.screen.Profile
import androidx.annotation.DrawableRes
import com.afs.tutrd.R
import com.afs.tutrd.navigation.classroom.screen.Classroom
import com.afs.tutrd.navigation.home.screen.Home
import com.afs.tutrd.navigation.session.screen.Session
import com.afs.tutrd.navigation.pay.screen.Pay

// FIXME ui fix 되면 메뉴 추가

/**
 * Bottom Menu 정리한 enum class
 * 아직 디자인 픽스가 안돼서 아직 전부 추가는 안 했습니다
 */
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
    SESSION(
        qualifierName = Session::class.java.name,
        iconId = R.drawable.ic_launcher_foreground, // FIXME ui fix 되면 Icon 변경
        label = "session"
    ),
    PAY(
        qualifierName = Pay::class.java.name,
        iconId = R.drawable.ic_launcher_foreground, // FIXME ui fix 되면 Icon 변경
        label = "pay"
    ),
    CLASSROOM(
        qualifierName = Classroom::class.java.name,
        iconId = R.drawable.ic_launcher_foreground, // FIXME ui fix 되면 Icon 변경
        label = "classroom"
    ),
    PROFILE(
        qualifierName = Profile::class.java.name,
        iconId = R.drawable.ic_launcher_foreground, // FIXME ui fix 되면 Icon 변경
        label = "profile"
    ),
}