package com.afs.tutrd.presentation.profile.view

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afs.tutrd.component.divider.Divider
import com.afs.tutrd.component.scaffold.TutrdScaffold

@Composable
fun ProfileScreen(modifier: Modifier) {

    val scrollState = rememberScrollState()

    TutrdScaffold(
        topBar = { ProfileTopBar(title = "프로필") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            TuteeTutorToggleBar()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Divider(title = "정보")
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "이름"
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "정환"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "이메일"
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "qwer123@naver.com"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "연락처"
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "010-9025-8656"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "주요분야"
                    )
                    Text(
                        fontSize = 16.sp,
                        text = "수학, 코딩"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "한줄소개"
                    )
                    Text(
                        fontSize = 16.sp,
                        text = "입력해주세요"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Divider(title = "서비스")

                TextButton(
                    modifier = Modifier
                        .height(24.dp),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "서비스 이용약관",
                    )
                }
                TextButton(
                    modifier = Modifier
                        .height(24.dp),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "개인정보 처리방침",
                    )
                }
                TextButton(
                    modifier = Modifier
                        .height(24.dp),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "오픈소스 라이선스",
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Divider(title = "계정")
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "아이디"
                    )
                    Text(
                        modifier = Modifier
                            .alpha(0.5f),
                        fontSize = 16.sp,
                        text = "qwer123@naver.com"
                    )
                }
                TextButton(
                    modifier = Modifier
                        .height(24.dp),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "비밀번호 변경",
                    )
                }
                TextButton(
                    modifier = Modifier
                        .height(24.dp),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "로그아웃",
                    )
                }
                TextButton(
                    modifier = Modifier
                        .height(24.dp),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        text = "탈퇴",
                    )
                }

            }

        }
    }
}
//
//@Preview
//@Composable
//fun preview() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth(),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        Divider(title = "서비스")
//
//        TextButton(
//            modifier = Modifier
//                .height(24.dp),
//            colors = ButtonColors(
//                containerColor = Color.Transparent,
//                contentColor = Color.Black,
//                disabledContentColor = Color.Gray,
//                disabledContainerColor = Color.Gray),
//            contentPadding = PaddingValues(0.dp),
//            onClick = { /*TODO*/ }
//        ) {
//            Text(
//                fontWeight = FontWeight.Bold,
//                fontSize = 16.sp,
//                text = "서비스 이용약관",
//            )
//        }
//        TextButton(
//            modifier = Modifier
//                .height(24.dp),
//            colors = ButtonColors(
//                containerColor = Color.Transparent,
//                contentColor = Color.Black,
//                disabledContentColor = Color.Gray,
//                disabledContainerColor = Color.Gray),
//            contentPadding = PaddingValues(0.dp),
//            onClick = { /*TODO*/ }
//        ) {
//            Text(
//                fontWeight = FontWeight.Bold,
//                fontSize = 16.sp,
//                text = "개인정보 처리방침",
//            )
//        }
//        TextButton(
//            modifier = Modifier
//                .height(24.dp),
//            colors = ButtonColors(
//                containerColor = Color.Transparent,
//                contentColor = Color.Black,
//                disabledContentColor = Color.Gray,
//                disabledContainerColor = Color.Gray),
//            contentPadding = PaddingValues(0.dp),
//            onClick = { /*TODO*/ }
//        ) {
//            Text(
//                fontWeight = FontWeight.Bold,
//                fontSize = 16.sp,
//                text = "오픈소스 라이선스",
//            )
//        }
//    }
//}