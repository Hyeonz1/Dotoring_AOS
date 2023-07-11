package com.example.dotoring.ui.register


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.register.util.RegisterScreenTop
import com.example.dotoring.ui.register.util.RegisterScreenNextButton
import com.example.dotoring.ui.theme.DotoringTheme


@Composable
private fun Introduce() {
    Row() {

        Text(
            text = stringResource(id = R.string.register1_im),
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 18.sp)

        Spacer(modifier = Modifier.size(25.dp))

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
            modifier = Modifier.size(width = 120.dp, height = 40.dp),
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
        Spacer(modifier = Modifier.size(25.dp))
        Text(
            text = text,
            fontSize = 18.sp)
    }
}


@Composable
fun RegisterScreenFirst() {
    Column(
        modifier = Modifier.padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisterScreenTop(1, R.string.register1_q1)

        Spacer(modifier = Modifier.size(100.dp))

        Column {
            Introduce()

            Spacer(modifier = Modifier.size(100.dp))

            RegisterScreenNextButton()
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