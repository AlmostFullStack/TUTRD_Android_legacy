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
import com.afs.tutrd.navigation.sessionlist.navigateToSessionList
import com.afs.tutrd.navigation.pay.navigateToPay
import com.afs.tutrd.navigation.pay.screen.Pay
import com.afs.tutrd.navigation.profile.navigateToProfile
import com.afs.tutrd.navigation.profile.screen.Profile
import com.afs.tutrd.navigation.session.navigateToSession
import com.afs.tutrd.navigation.session.screen.Session
import com.afs.tutrd.navigation.sessionlist.screen.SessionList

/**
 * Bottom Bar navigation 을 위해 작성한 navController
 *
 * [BottomMenuTabs] 와 다르면 메인 bottomBar를 보여주지 않기 위해 작성 했습니다
 *
 */
@Composable
fun rememberTutrdNavController(navController: NavHostController = rememberNavController()) =
    remember { TutrdNavController(navController = navController) } //선언

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
            SessionList::class.java.name -> BottomMenuTabs.SESSIONLIST
            Pay::class.java.name -> BottomMenuTabs.PAY
            Classroom::class.java.name -> BottomMenuTabs.CLASSROOM
            Session::class.java.name -> BottomMenuTabs.SESSION
            else -> null
        }
    }

    fun navigate(route: BottomMenuTabs) {
        if (route.qualifierName == navController.currentDestination?.route) return
        val navOptionsPopUp = navOptions {
            popUpTo(navController.graph.id) {
                saveState = true
                inclusive = false
            }
            launchSingleTop  = true
            restoreState = true
        }
        val navOptionsNoPopUp = navOptions {
            launchSingleTop  = true
            restoreState = true
        }
        when (route) {
            BottomMenuTabs.HOME -> navController.navigateToHome(navOptionsPopUp)
            BottomMenuTabs.PROFILE -> navController.navigateToProfile(navOptionsPopUp)
            BottomMenuTabs.SESSIONLIST -> navController.navigateToSessionList(navOptionsPopUp)
            BottomMenuTabs.PAY -> navController.navigateToPay(navOptionsPopUp)
            BottomMenuTabs.CLASSROOM -> navController.navigateToClassroom(navOptionsPopUp)
            BottomMenuTabs.SESSION -> navController.navigateToSession(navOptionsNoPopUp)
        }
    }
}