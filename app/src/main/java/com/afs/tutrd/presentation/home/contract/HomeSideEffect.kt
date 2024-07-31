package com.afs.tutrd.presentation.home.contract

import com.afs.tutrd.common.base.UiSideEffect

sealed class HomeSideEffect(): UiSideEffect() {
    data object NavigateToNextMonth: HomeSideEffect()
    data object NavigateToPrevMonth: HomeSideEffect()
}