package com.afs.tutrd.navigation.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.afs.tutrd.navigation.home.navigateToHome
import com.afs.tutrd.navigation.home.screen.Home
import com.afs.tutrd.navigation.profile.navigateToProfile
import com.afs.tutrd.navigation.profile.screen.Profile

/**
 * Bottom Tab 을 위한 navigation
 *
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
        }
    }
}