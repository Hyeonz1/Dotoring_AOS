package com.example.dotoring.ui.Calender

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dotoring.R
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun CalenderScreen(){
    Box(){
        Image(
            painter=painterResource(R.drawable.sample),
            contentDescription=null,
            contentScale = ContentScale.FillWidth)
    }

}


@Preview
@Composable
private fun CalenderPreview() {
    DotoringTheme {
        CalenderScreen()
    }
}