package com.afs.tutrd.navigation.session

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.afs.tutrd.R
import com.afs.tutrd.navigation.session.screen.Session
import com.afs.tutrd.presentation.session.view.SessionScreen

internal fun NavGraphBuilder.sessionScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
) {
    composable<Session> {
        SessionScreen(
            modifier = modifier,
            navigateUp = navigateUp)
    }
}

internal fun NavController.navigateToSession(navOptions: NavOptions) {
    navigate(
        route = Session,
        navOptions = navOptions
    )
}