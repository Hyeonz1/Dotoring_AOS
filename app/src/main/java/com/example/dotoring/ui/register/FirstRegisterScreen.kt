package com.example.dotoring.ui.register


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.theme.DotoringTheme
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
private fun Introduce() {
    Row() {
        Text(
            text = stringResource(id = R.string.register1_im),
            modifier = Modifier.padding(top = 10.dp))

        Spacer(modifier = Modifier.size(10.dp))

        Column() {

            IntroduceContent(
                textField = stringResource(id = R.string.register1_company),
                text = stringResource(R.string.register1_belong_to)
            )

            Spacer(modifier = Modifier.size(10.dp))

            IntroduceContent(
                textField = stringResource(id = R.string.register1_years),
                text = stringResource(R.string.register1_years_of_experience)
            )

            Spacer(modifier = Modifier.size(10.dp))

            IntroduceContent(
                textField = stringResource(id = R.string.register1_work),
                text = stringResource(R.string.register1_)
            )

        }
    }
}

@Composable
private fun IntroduceContent(textField: String, text: String ) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.size(width = 110.dp, height = 40.dp),
            placeholder = { Text(
                                text = textField,
                                fontSize = 13.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.black),
                focusedIndicatorColor = colorResource(id = R.color.black),
                unfocusedIndicatorColor = colorResource(id = R.color.black),
                backgroundColor = colorResource(id = R.color.white),
                placeholderColor = colorResource(id = R.color.grey_500)

            ))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = text)
    }
}

@Composable
fun CommonRegisterScreen(screenNumber: Int, question: Int) {
    Row(
        modifier = Modifier.padding(start = 50.dp, top = 50.dp, end = 50.dp)
    ) {
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
        Spacer(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun RegisterScreenFirst() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonRegisterScreen(1, R.string.register1_q1)

        Spacer(modifier = Modifier.size(100.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Introduce()
            Spacer(modifier = Modifier.size(100.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(width = 300.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.white),
                    backgroundColor = colorResource(id = R.color.green),
                    disabledBackgroundColor = colorResource(id = R.color.grey_200),
                    disabledContentColor = colorResource(id = R.color.grey_500)
                ),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(text = stringResource(id = R.string.register1_next))
            }
        }

    }
    // HtmlText(textId = R.string.register_title)
}


@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    DotoringTheme {
        RegisterScreenFirst()
    }
}