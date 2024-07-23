package com.afs.tutrd.navigation.lecture

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afs.tutrd.navigation.lecture.screen.Lecture
import com.afs.tutrd.presentation.lecture.LectureScreen

internal fun NavGraphBuilder.lectureScreen(
    modifier: Modifier = Modifier
) {
    composable<Lecture> {
        LectureScreen(modifier = modifier)
    }
}

internal fun NavController.navigateToLecture(navOptions: NavOptions) {
    navigate(
        route = Lecture,
        navOptions = navOptions
    )
}