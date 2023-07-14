package com.example.dotoring.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun MentoCard() {
    val space: Dp = 5.dp
    val spaceBetweenPhotoAndDescription: Dp = 10.dp

    Card(
        modifier = Modifier
            .size(width = 284.dp, height = 127.dp)
            .clip(RoundedCornerShape(20.dp)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val img = R.drawable.sample

            Spacer(modifier = Modifier.size(25.dp))

            Image(
                painter = painterResource(id=img),
                contentDescription = "멘토 사진",
                modifier = Modifier
                    .size(width = 83.dp, height = 91.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

            Spacer(modifier = Modifier.size(spaceBetweenPhotoAndDescription))

            Column() {
                Text(
                    text = "닉네임",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.navy)
                )

                Spacer(modifier = Modifier.size(space))

                Text(
                    text = "학과",
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.size(space))

                Text(
                    text = "희망 직무 분야",
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.size(space))

                Text(
                    text = "한 줄 소개",
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
        MentoCard()
    }
}