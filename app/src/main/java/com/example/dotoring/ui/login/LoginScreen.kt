package com.example.dotoring.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.TintableBackgroundView
import com.example.dotoring.R

class LoginScreen {
    @Composable
    fun LoginScreen(
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter=painterResource(R.drawable.dotoring_background_logo),
                contentDescription=null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(horizontal = 38.dp, vertical = 178.dp)
            ) {
                Column {
                    Text(text = stringResource(id = R.string.university), fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.mentor_login1),fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.login_text), fontSize = 13.sp)
                }
                Spacer(modifier = Modifier.size(40.dp))

                Column(
                    modifier= Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth()
                ) {
                    LoginField(
                        textField = stringResource(id = R.string.login)
                    )
                    LoginField(
                        textField = stringResource(id = R.string.password)
                    )
                }
                Spacer(modifier = Modifier.size(40.dp))

                OutlinedButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    border = BorderStroke(width = 2.dp, Color.Black)

                ) { Text(text = "로그인", fontSize = 15.sp) }




                TextButton(
                    modifier=Modifier.align(alignment = Alignment.CenterHorizontally),
                    onClick = { /*TODO*/ },
                )
                {
                    Text("아이디 찾기", fontSize = 12.sp,color= colorResource(id = R.color.grey_500), modifier = Modifier
                        .clickable {
                            // onClick()
                        }
                    )
                    Text(text = "  |  ", fontSize = 12.sp,color= colorResource(id = R.color.grey_500))
                    Text("비밀번호 찾기", fontSize = 12.sp, color= colorResource(id = R.color.grey_500), modifier = Modifier
                        .clickable {
                            // onClick() }
                        }
                    )
                    Text(text = "  |  ", fontSize = 12.sp)
                    Text("회원가입", fontSize = 12.sp, color= colorResource(id = R.color.grey_500), modifier = Modifier
                        .clickable {
                            // onClick()
                        }
                    )

                }
            }
        }
    }

@Composable
fun LoginValueErrMsg(){

}


@Composable
fun LoginField(textField: String) {
    Column() {TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(
            text = textField,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            focusedIndicatorColor = colorResource(id = R.color.black),
            unfocusedIndicatorColor = colorResource(id = R.color.black),
            backgroundColor = colorResource(id = R.color.white),
            placeholderColor = colorResource(id = R.color.grey_500)))

    }
}


@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}
}
