package com.example.dotoring.ui.register.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import de.charlex.compose.HtmlText

@Composable
private fun ProgressBar(page: Int) {

    val space = 5.dp
    val imageModifier = Modifier
        .size(20.dp)

    Row() {

        for(i in 1..page) {
            Image(painter = painterResource(R.drawable.register_progress_done), contentDescription = "", modifier = imageModifier)
            Spacer(modifier = Modifier.size(space))
        }

        for(i in 1..6-page) {
            Image(painter = painterResource(R.drawable.register_progress_default), contentDescription = "", modifier = imageModifier)
            Spacer(modifier = Modifier.size(space))
        }

    }

}

@Composable
fun RegisterScreenTop(screenNumber: Int, question: Int) {
    Row() {
        Column() {
            HtmlText(
                textId = R.string.register_title,
                fontSize = 15.sp)
            Spacer(modifier = Modifier.size(80.dp))
            ProgressBar(screenNumber)
            Spacer(modifier = Modifier.size(10.dp))
            HtmlText(
                textId = question,
                fontSize = 18.sp)
        }
    }
}