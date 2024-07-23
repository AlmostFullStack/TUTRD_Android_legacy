package com.afs.tutrd.navigation.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.afs.tutrd.navigation.classroom.navigateToClassroom
import com.afs.tutrd.navigation.classroom.screen.Classroom
import com.afs.tutrd.navigation.home.navigateToHome
import com.afs.tutrd.navigation.home.screen.Home
import com.afs.tutrd.navigation.lecture.navigateToLecture
import com.afs.tutrd.navigation.lecture.screen.Lecture
import com.afs.tutrd.navigation.pay.navigateToPay
import com.afs.tutrd.navigation.pay.screen.Pay
import com.afs.tutrd.navigation.profile.navigateToProfile
import com.afs.tutrd.navigation.profile.screen.Profile

/**
 * Bottom Bar navigation 을 위해 작성한 navController
 *
 * [BottomMenuTabs] 와 다르면 메인 bottomBar를 보여주지 않기 위해 작성 했습니다
 *
 */
@Composable
fun rememberTutrdNavController(navController: NavHostController = rememberNavController()) =
    remember { TutrdNavController(navController = navController) }

class TutrdNavController(
    val navController: NavHostController
) {
    private val navBackStackEntry: NavBackStackEntry?
        @Composable get() = navController.currentBackStackEntryAsState().value

    private val routes: List<String>
        @Composable get() = remember { BottomMenuTabs.entries.map { it.qualifierName } }

    private val currentRoute: String?
        @Composable get() = navBackStackEntry?.destination?.route

    @Composable
    fun isInBottomTabs(): Boolean = currentRoute in routes

    @Composable
    fun mapRouteToTab(): BottomMenuTabs? {
        return when (currentRoute) {
            Home::class.java.name -> BottomMenuTabs.HOME
            Profile::class.java.name -> BottomMenuTabs.PROFILE
            Lecture::class.java.name -> BottomMenuTabs.LECTURE
            Pay::class.java.name -> BottomMenuTabs.PAY
            Classroom::class.java.name -> BottomMenuTabs.CLASSROOM
            else -> null
        }
    }

    fun navigate(route: BottomMenuTabs) {
        if (route.qualifierName == navController.currentDestination?.route) return
        val navOptions = navOptions {
            popUpTo(navController.graph.id) {
                saveState = true
                inclusive = false
            }
            launchSingleTop  = true
            restoreState = true
        }
        when (route) {
            BottomMenuTabs.HOME -> navController.navigateToHome(navOptions)
            BottomMenuTabs.PROFILE -> navController.navigateToProfile(navOptions)
            BottomMenuTabs.LECTURE -> navController.navigateToLecture(navOptions)
            BottomMenuTabs.PAY -> navController.navigateToPay(navOptions)
            BottomMenuTabs.CLASSROOM -> navController.navigateToClassroom(navOptions)
        }
    }
}