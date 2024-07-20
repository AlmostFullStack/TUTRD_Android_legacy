package com.afs.tutrd

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.afs.tutrd.component.bottomBar.BottomBar
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.navigation.controller.rememberTutrdNavController
import com.afs.tutrd.navigation.home.homeScreen
import com.afs.tutrd.navigation.home.screen.Home
import com.afs.tutrd.navigation.profile.profileScreen

@Composable
fun TutrdApp() {
    val tutrdNavController = rememberTutrdNavController()
    val navController = tutrdNavController.navController
    val isVisibleBottomBar = tutrdNavController.isInBottomTabs()

    val currentTab = tutrdNavController.mapRouteToTab()

    TutrdScaffold(
        bottomBar = {
            if (isVisibleBottomBar) {
                BottomBar(
                    current = currentTab,
                    onClick = { tutrdNavController.navigate(it) }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Home) {
            homeScreen(modifier = Modifier.padding(it))
            profileScreen(modifier = Modifier.padding(it))
        }
    }
}