package com.afs.tutrd.navigation.profile

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.navigation.profile.screen.Profile
import com.afs.tutrd.presentation.profile.ProfileScreen

internal fun NavGraphBuilder.profileScreen(
    modifier: Modifier = Modifier
) {
    composable<Profile> {
        ProfileScreen(modifier = modifier)
    }
}

internal fun NavController.navigateToProfile(navOptions: NavOptions) {
    navigate(
        route = Profile,
        navOptions = navOptions
    )
}