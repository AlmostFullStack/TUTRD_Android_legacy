package com.afs.tutrd.navigation.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.presentation.home.view.HomeScreen
import com.afs.tutrd.navigation.home.screen.Home


internal fun NavGraphBuilder.homeScreen(
    modifier: Modifier = Modifier
) {
    composable<Home> {
        HomeScreen(modifier = modifier)
    }
}

internal fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(
        route = Home,
        navOptions = navOptions
    )
}