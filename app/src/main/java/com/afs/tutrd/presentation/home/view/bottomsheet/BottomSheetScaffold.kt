package com.afs.tutrd.presentation.home.view.bottomsheet
//
//import androidx.compose.foundation.layout.ColumnScope
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material3.BottomSheetDefaults
//import androidx.compose.material3.BottomSheetScaffoldState
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.SnackbarHost
//import androidx.compose.material3.SnackbarHostState
//import androidx.compose.material3.contentColorFor
//import androidx.compose.material3.rememberBottomSheetScaffoldState
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@ExperimentalMaterialApi
//fun BottomSheetScaffold(
//    sheetContent: @Composable ColumnScope.() -> Unit,
//    modifier: Modifier = Modifier,
//    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
//    sheetPeekHeight: Dp = BottomSheetDefaults.SheetPeekHeight,
//    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
//    sheetShape: Shape = BottomSheetDefaults.ExpandedShape,
//    sheetContainerColor: Color = BottomSheetDefaults.ContainerColor,
//    sheetContentColor: Color = contentColorFor(sheetContainerColor),
//    sheetTonalElevation: Dp = 0.dp,
//    sheetShadowElevation: Dp = BottomSheetDefaults.Elevation,
//    sheetDragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
//    sheetSwipeEnabled: Boolean = true,
//    topBar: @Composable (() -> Unit)? = null,
//    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
//    containerColor: Color = MaterialTheme.colorScheme.surface,
//    contentColor: Color = contentColorFor(containerColor),
//    content: @Composable (PaddingValues) -> Unit
//) {}