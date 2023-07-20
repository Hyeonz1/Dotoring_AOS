package com.example.dotoring.ui.message

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.theme.DotoringTheme
import com.example.dotoring.ui.theme.Gray
import com.example.dotoring.ui.theme.Navy
import com.example.dotoring.ui.theme.Purple200
import com.example.dotoring.ui.theme.nanumSquareFamily
import kotlinx.coroutines.launch

    @Composable
    fun MessageBoxScreen(
    ) {
        val listSize = 100
        val scrollState = rememberLazyListState()

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 30.dp, vertical = 50.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("  쪽지함", fontFamily = nanumSquareFamily, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp,color= colorResource(id=R.color.black), modifier = Modifier )
            Spacer(modifier = Modifier.size(40.dp))

            Column {

                LazyColumn(state = scrollState) {
                    items(listSize) {
                        MessageListItem()
                    }
                }

            }
        }
    }

    @Composable
    fun MessageListItem(){
        Column() {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 10.dp)

            ) {
                Box(
                    modifier = Modifier
                        .width(270.dp)
                        .align(Alignment.CenterEnd)

                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape= RoundedCornerShape(15.dp)
                        , color = Gray
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp, top = 15.dp, bottom = 15.dp, end = 10.dp)

                        ) {
                            Text(
                                "시간: 00시 00분",
                                fontSize = 8.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End,
                                color = Color.Gray,
                                fontFamily = nanumSquareFamily, fontWeight = FontWeight.Normal
                            )
                            Text("닉네임은 여덟글자", fontSize = 15.sp, color = Navy,fontFamily = nanumSquareFamily, fontWeight = FontWeight.ExtraBold)
                            Text("학과", fontSize = 12.sp, fontFamily = nanumSquareFamily, fontWeight = FontWeight.Normal)
                            Spacer(modifier = Modifier.size(12.dp))
                            Text(
                                "마지막대화내용은열두글자",
                                fontSize = 12.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End,
                                fontFamily = nanumSquareFamily, fontWeight = FontWeight.Normal
                            )

                        }

                    }

                }
                Surface(
                    shape= CircleShape,
                    modifier = Modifier
                        .size(70.dp)
                        .align(Alignment.CenterStart)
                        .border(
                            width = 6.dp,
                            color = colorResource(id = R.color.white),
                            shape = CircleShape

                        )

                ) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .clip(CircleShape)
                    )

                }

            }
        }
    }


    @Preview(showSystemUi = true)
    @Composable
    fun MessageBoxPreview() {
        DotoringTheme {
        MessageBoxScreen()
    }
}
