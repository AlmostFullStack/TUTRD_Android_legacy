package com.afs.tutrd.navigation.sessionlist

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.navigation.sessionlist.screen.SessionList
import com.afs.tutrd.presentation.sessionlist.view.SessionListScreen

internal fun NavGraphBuilder.sessionListScreen(
    modifier: Modifier = Modifier,
    navigateToSession: () -> Unit
) {
    composable<SessionList> {
        SessionListScreen(
            modifier = modifier,
            navigateToSession = navigateToSession)
    }
}

internal fun NavController.navigateToSessionList(navOptions: NavOptions) {
    navigate(
        route = SessionList,
        navOptions = navOptions
    )
}