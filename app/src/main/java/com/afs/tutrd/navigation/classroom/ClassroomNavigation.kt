package com.afs.tutrd.navigation.classroom

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.navigation.classroom.screen.Classroom
import com.afs.tutrd.presentation.classroom.ClassroomScreen


internal fun NavGraphBuilder.classroomScreen(
    modifier: Modifier = Modifier
) {
    composable<Classroom> {
        ClassroomScreen(modifier = modifier)
    }
}

internal fun NavController.navigateToClassroom(navOptions: NavOptions) {
    navigate(
        route = Classroom,
        navOptions = navOptions
    )
}