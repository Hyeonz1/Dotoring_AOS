package com.example.dotoring.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.runtime.getValue
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dotoring.R
import com.example.dotoring.navigation.Graph
import com.example.dotoring.navigation.MentiDetailScreen
import com.example.dotoring.ui.detail.MentiDetailedViewModel
import com.example.dotoring.ui.home.data.Mentee
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun MenteeCard(mentee: Mentee, navController: NavHostController, menteeDetailedViewModel: MentiDetailedViewModel = viewModel()) {

    val menteeDetailedUiState by menteeDetailedViewModel.uiState.collectAsState()

    val space: Dp = 5.dp
    val spaceBetweenPhotoAndDescription: Dp = 10.dp

    val nickname = mentee.nickname
    val profileImage = mentee.profileImage
    val major = mentee.major
    val job = mentee.job
    val introduction = mentee.introduction

    Card(
        modifier = Modifier
            .size(width = 284.dp, height = 127.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                navController.navigate(Graph.MENTI_DETAILS)

            },
        elevation = 5.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val img = R.drawable.sample

            Spacer(modifier = Modifier.size(25.dp))

            Image(
                painter = painterResource(id=profileImage),
                contentDescription = "멘토 사진",
                modifier = Modifier
                    .size(width = 83.dp, height = 91.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.size(spaceBetweenPhotoAndDescription))

            Column() {
                Text(
                    text = nickname,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.navy)
                )

                Spacer(modifier = Modifier.size(space))

                Text(
                    text = major,
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.size(space))

                Text(
                    text = job,
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.size(space))

                Text(
                    text = introduction,
                    fontSize = 10.sp
                )
            }


        }
    }
}


@Preview
@Composable
private fun HomePreview() {
    DotoringTheme {
        MenteeCard((Mentee(nickname = "현지", profileImage = R.drawable.sample, major = "소프트웨어공학과", job = "개발자", introduction = "하이")), navController = rememberNavController())
    }
}