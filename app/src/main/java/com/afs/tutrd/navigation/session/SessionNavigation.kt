package com.afs.tutrd.navigation.session

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.navigation.session.screen.Session
import com.afs.tutrd.presentation.session.view.SessionScreen

internal fun NavGraphBuilder.sessionScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
) {
    composable<Session>(
        enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) },
        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300))}

    ) {
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