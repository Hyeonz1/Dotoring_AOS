package com.example.dotoring.ui.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.register.util.CommonTextField
import com.example.dotoring.ui.register.util.EffectiveCheckButton
import com.example.dotoring.ui.register.util.RegisterScreenTop
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun SixthRegisterScreen() {
    var idInput by remember { mutableStateOf("") }
    var passWordInput by remember { mutableStateOf("") }
    var passWordVerificationInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var verificationCode by remember { mutableStateOf("") }

    val checkedState = remember { mutableStateOf(true) }

    val width: Dp = 310.dp

    val spaceBetweenTitleAndContent: Dp = 18.dp
    val spaceBetweenSurface: Dp = 15.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 50.dp)
    ) {
        RegisterScreenTop(screenNumber = 6, question = R.string.register6_q6)

        Spacer(modifier = Modifier.weight(1.5f))

        Column() {
            Text(
                text = stringResource(id = R.string.register6_set_ID),
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.size(spaceBetweenTitleAndContent))

            Column() {

                TextFieldWithEffectiveCheckButton(
                    value = idInput,
                    onValueChange = {idInput = it},
                    placeholder = stringResource(id = R.string.register6_ID),
                    btnText = stringResource(R.string.register_nickname_duplication_check),
                    width = width
                )

                Text(
                    text = stringResource(id = R.string.register6_ID_guide),
                    modifier = Modifier
                        .padding(start = 2.dp, top = 3.dp),
                    color = colorResource(id = R.color.grey_500),
                    fontSize = 10.sp
                )


                Text(
                    text = stringResource(id = R.string.register6_ID_error),
                    modifier = Modifier
                        .padding(start = 2.dp, top = 3.dp),
                    color = colorResource(id = R.color.error),
                    fontSize = 10.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(spaceBetweenSurface))

        Column() {
            Text(
                text = stringResource(id = R.string.register6_set_pass_word),
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.size(spaceBetweenTitleAndContent))

            CommonTextField(
                value = passWordInput,
                onValueChange = { passWordInput = it },
                placeholder = stringResource(id = R.string.register6_pass_word),
                width = width
            )

            Column() {
                Box(
                    contentAlignment = Alignment.CenterEnd
                ) {
                    CommonTextField(
                        value = passWordVerificationInput,
                        onValueChange = { passWordVerificationInput = it },
                        placeholder = stringResource(id = R.string.register6_pass_word_check),
                        width = width
                    )

                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.green),
                            uncheckedColor = colorResource(id = R.color.grey_500),
                            checkmarkColor = Color(0xffffffff)
                        )
                    )
                }

                Text(
                    text = stringResource(id = R.string.register6_pass_word_error),
                    modifier = Modifier
                        .padding(start = 2.dp, top = 3.dp),
                    color = colorResource(id = R.color.error),
                    fontSize = 10.sp
                )
            }

        }

        Spacer(modifier = Modifier.size(spaceBetweenSurface))

        Column() {
            Text(
                text = stringResource(id = R.string.register6_set_email),
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.size(spaceBetweenTitleAndContent))
            
            Column(
                horizontalAlignment = Alignment.End
            ) {

                TextFieldWithEffectiveCheckButton(
                    value = emailInput,
                    onValueChange = { emailInput = it },
                    placeholder = stringResource(id = R.string.register6_email),
                    btnText = stringResource(R.string.register6_send_verification_code),
                    width = width
                )

                Text(
                    text = stringResource(id = R.string.register6_verification_code_time),
                    modifier = Modifier
                        .padding(end = 2.dp, top = 3.dp),
                    color = colorResource(id = R.color.error),
                    fontSize = 10.sp
                )

                Column() {
                    TextFieldWithEffectiveCheckButton(
                        value = verificationCode,
                        onValueChange = { verificationCode = it },
                        placeholder = stringResource(id = R.string.register6_verification_code),
                        btnText = stringResource(R.string.register6_verify),
                        width = width
                    )

                    Text(
                        text = stringResource(id = R.string.register6_verify_error),
                        modifier = Modifier
                            .padding(start = 2.dp, top = 3.dp),
                        color = colorResource(id = R.color.error),
                        fontSize = 10.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Register6ScreenNextButton()

        Spacer(modifier = Modifier.weight(0.8f))
    }
}

@Composable
private fun Register6ScreenNextButton(onClick: ()->Unit = {}) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(width = 300.dp, height = 45.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(id = R.color.white),
            backgroundColor = colorResource(id = R.color.green),
            disabledBackgroundColor = colorResource(id = R.color.grey_200),
            disabledContentColor = colorResource(id = R.color.grey_500)
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(text = stringResource(id = R.string.register6_to_login_page))
    }
}

@Composable
private fun TextFieldWithEffectiveCheckButton(value: String, onValueChange: (String) -> Unit, placeholder: String, btnText: String, width: Dp) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.CenterEnd
    ) {
        CommonTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            width = width
        )

        EffectiveCheckButton(text = btnText)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    DotoringTheme {
        SixthRegisterScreen()
    }
}