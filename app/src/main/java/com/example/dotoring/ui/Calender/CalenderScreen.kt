package com.example.dotoring.ui.Calender

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import com.example.dotoring.navigation.MentiDetailScreen
import com.example.dotoring.ui.detail.MentiDetailedViewModel
import com.example.dotoring.ui.home.data.Mentee
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun CalenderScreen(){
    Box(){
        Image(
            painter=painterResource(R.drawable.calender),
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