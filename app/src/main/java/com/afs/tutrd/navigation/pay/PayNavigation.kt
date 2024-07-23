package com.afs.tutrd.navigation.pay

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.navigation.pay.screen.Pay
import com.afs.tutrd.presentation.pay.PayScreen

internal fun NavGraphBuilder.payScreen(
    modifier: Modifier = Modifier
) {
    composable<Pay> {
        PayScreen(modifier = modifier)
    }
}

internal fun NavController.navigateToPay(navOptions: NavOptions) {
    navigate(
        route = Pay,
        navOptions = navOptions
    )
}