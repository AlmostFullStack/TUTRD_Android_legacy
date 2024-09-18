package com.afs.tutrd

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.afs.tutrd.component.bottomBar.BottomBar
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.navigation.classroom.classroomScreen
import com.afs.tutrd.navigation.controller.BottomMenuTabs
import com.afs.tutrd.navigation.controller.rememberTutrdNavController
import com.afs.tutrd.navigation.home.homeScreen
import com.afs.tutrd.navigation.home.screen.Home
import com.afs.tutrd.navigation.sessionlist.sessionListScreen
import com.afs.tutrd.navigation.pay.payScreen
import com.afs.tutrd.navigation.profile.profileScreen
import com.afs.tutrd.navigation.session.sessionScreen
import android.util.Log

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
        NavHost(
            navController = navController,
            startDestination = Home,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            homeScreen(
                modifier = Modifier.padding(it),
                navigateToSession = { tutrdNavController.navigate(BottomMenuTabs.SESSION) }
            )
            sessionListScreen(
                modifier = Modifier.padding(it),
                navigateToSession = { tutrdNavController.navigate(BottomMenuTabs.SESSION) }
            )
            payScreen(modifier = Modifier.padding(it))
            classroomScreen(modifier = Modifier.padding(it))
            profileScreen(modifier = Modifier.padding(it))
            sessionScreen(
                modifier = Modifier.padding(it),
                navigateUp = {
                    tutrdNavController.navController.navigateUp()
                    Log.d("@@@ROUTING", "backstack clicked")
                })
        }
    }
}