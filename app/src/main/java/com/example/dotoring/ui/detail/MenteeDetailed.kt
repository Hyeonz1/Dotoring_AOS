package com.example.dotoring.ui.detail

import android.util.Log
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dotoring.R
import com.example.dotoring.ui.register.sixth.RegisterSixthViewModel
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun MenteeDetailed(menteeDetailedViewModel: MentiDetailedViewModel = viewModel(),
                   navController: NavController) {
    val menteeDetailedUiState by menteeDetailedViewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = colorResource(id = R.color.navy)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_mail),
                    contentDescription = "send mail to mentee",
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) { it ->
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_mentee_detailed),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                     modifier = Modifier
                         .fillMaxSize()
                         .padding(top = 100.dp)

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        (if(menteeDetailedUiState.profileImage != null){
                                menteeDetailedUiState.profileImage
                            } else { R.drawable.sample })?.let { it1 ->
                                Image(
                                    painter = painterResource(id = it1),
                                    contentDescription = null,
                                    modifier = Modifier.size(100.dp)
                                        .clip(
                                            RoundedCornerShape(20.dp),
                                ))
                            }


                        Spacer(modifier = Modifier.size(10.dp))

                        (if(menteeDetailedUiState.major != null){
                            menteeDetailedUiState.major
                        } else {"소프트웨어공학과"})?.let { it1 ->
                            Text(
                                text = it1,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Spacer(modifier = Modifier.size(5.dp))

                        (if(menteeDetailedUiState.nickname != null){
                            menteeDetailedUiState.nickname
                        } else {"도토리"})?.let { it1 ->
                            Text(
                                text = it1,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = colorResource(id = R.color.navy)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.size(40.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 50.dp, end = 50.dp),
                        horizontalAlignment = Alignment.Start

                    ) {
                        Column() {
                            Text(
                                text = "희망 직무 분야",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.size(8.dp))

                            (if(menteeDetailedUiState.job != null){
                                menteeDetailedUiState.job
                            } else {"도토리"})?.let { it1 ->
                                Text(
                                    text = it1,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.navy)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(30.dp))

                        Column {
                            Text(
                                text = "한 줄 소개",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.size(8.dp))

                            (if(menteeDetailedUiState.introduction != null){
                                menteeDetailedUiState.introduction
                            } else {"도토리"})?.let { it1 ->
                                Text(
                                    text = it1,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.navy)
                                )

                        }

                        Spacer(modifier = Modifier.size(30.dp))

                        Column() {
                            Text(
                                text = "원하는 멘토링",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(
                                text = menteeDetailedUiState.mentoring,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }
                }

            }
        }
    }


}}

/*
@Preview
@Composable
fun MenteeDetailedPreview() {
    DotoringTheme() {
        MenteeDetailed(navController = rememberNavController())
        */
/*SearchField(value = "", onValueChange = { })*//*

    }
}*/
