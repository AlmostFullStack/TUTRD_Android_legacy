package com.afs.tutrd.presentation.profile.view

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.afs.tutrd.component.card.Card
import com.afs.tutrd.component.divider.Divider
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.presentation.home.viewmodel.HomeViewModel

//@Composable
//fun InfoRow(title: String, value: String, isDimmed: Boolean = false) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            text = title
//        )
//        Text(
//            modifier = if (isDimmed) Modifier.alpha(0.5f) else Modifier,
//            fontSize = 16.sp,
//            text = value
//        )
//    }
//}
//
//@Composable
//fun ProfileTextButton(text: String, onClick: () -> Unit) {
//    TextButton(
//        modifier = Modifier
//            .height(24.dp)
//            .width(IntrinsicSize.Max),
//        colors = ButtonColors(
//            containerColor = Color.Transparent,
//            contentColor = Color.Black,
//            disabledContentColor = Color.Gray,
//            disabledContainerColor = Color.Gray),
//        contentPadding = PaddingValues(0.dp),
//        onClick = onClick
//    ) {
//        Text(
//            modifier = Modifier
//                .fillMaxWidth(),
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            text = text
//        )
//    }
//}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val scrollState = rememberScrollState()

    TutrdScaffold(
        topBar = { ProfileTopBar(title = "프로필") }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 20.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Card() {

            }

//            TuteeTutorToggleBar()
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                Divider(title = "정보")
//                InfoRow(title = "이름", value = "정환")
//                InfoRow(title = "이메일", value = "qwer123@naver.com")
//                InfoRow(title = "연락처", value = "010-9025-8656")
//                InfoRow(title = "주요분야", value = "수학, 코딩")
//                InfoRow(title = "한줄소개", value = "입력해주세요")
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                Divider(title = "서비스")
//
//                ProfileTextButton(text = "서비스 이용약관", onClick = { /* TODO */ })
//                ProfileTextButton(text = "개인정보 처리방침", onClick = { /* TODO */ })
//                ProfileTextButton(text = "오픈소스 라이선스", onClick = { /* TODO */ })
//
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                Divider(title = "계정")
//                InfoRow(title = "아이디", value = "qwer123@naver.com", isDimmed = true)
//                ProfileTextButton(text = "비밀번호 변경", onClick = { /* TODO */ })
//                ProfileTextButton(text = "로그아웃", onClick = { /* TODO */ })
//                ProfileTextButton(text = "탈퇴", onClick = { /* TODO */ })
//            }
    }
}}