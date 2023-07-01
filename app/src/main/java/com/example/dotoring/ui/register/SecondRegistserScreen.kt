package com.example.dotoring.ui.register

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.theme.DotoringTheme
import de.charlex.compose.HtmlText

@Composable
private fun ImageUploadButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(width = 300.dp, height = 80.dp),
        border = BorderStroke(width = 0.5.dp, color = colorResource(id = R.color.grey_200)),
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(id = R.color.black),
            backgroundColor = colorResource(id = R.color.white),
            disabledBackgroundColor = colorResource(id = R.color.white),
            disabledContentColor = colorResource(id = R.color.black)
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = stringResource(id = R.string.register2_upload_extension))
    }
}

@Composable
fun SecondRegisterScreen() {
    Column(
        modifier = Modifier.padding(start = 50.dp, top = 50.dp)
    ) {
        CommonRegisterScreen(screenNumber = 2, question = R.string.register2_q2)

        Spacer(modifier = Modifier.padding(35.dp))

        Column {
            HtmlText(
                textId = R.string.register2_upload_certificate_of_employment,
                fontSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            ImageUploadButton()

            Spacer(modifier = Modifier.size(50.dp))

            Row(verticalAlignment = Alignment.Bottom) {

                HtmlText(
                    textId = R.string.register2_upload_certificate_of_graduate,
                    fontSize = 18.sp)
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = stringResource(id = R.string.register2_upload_choice),
                    fontSize = 13.sp)
            }

            Spacer(modifier = Modifier.size(10.dp))

            ImageUploadButton()

            Spacer(modifier = Modifier.size(60.dp))

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
}

@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    DotoringTheme {
        SecondRegisterScreen()
    }
}