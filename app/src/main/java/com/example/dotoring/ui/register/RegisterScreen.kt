package com.example.dotoring.ui.register


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotoring.R
import com.example.dotoring.ui.theme.DotoringTheme
import de.charlex.compose.HtmlText

@Composable
fun ProgressBar(page: Int) {

    val space = 5.dp

    val imageModifier = Modifier
        .size(14.dp)


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
fun Introduce() {
    Row() {
        Text(text = stringResource(id = R.string.register1_im))

        Column() {

            IntroduceContent(
                textField = stringResource(id = R.string.register1_company),
                text = stringResource(R.string.register1_belong_to)
            )

            IntroduceContent(
                textField = stringResource(id = R.string.register1_years),
                text = stringResource(R.string.register1_years_of_experience)
            )

            IntroduceContent(
                textField = stringResource(id = R.string.register1_work),
                text = stringResource(R.string.register1_)
            )

        }
    }
}

@Composable
fun IntroduceContent(textField: String, text: String ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(value = textField, onValueChange = {})
        Text(text = text)
    }
}

@Composable
fun RegisterScreenFirst() {
    Column() {
        HtmlText(textId = R.string.register_title)
        ProgressBar(page = 1)
        HtmlText(textId = R.string.register1_q1)
        Introduce()
    }
    // HtmlText(textId = R.string.register_title)
}


@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    DotoringTheme {
        RegisterScreenFirst()
    }
}