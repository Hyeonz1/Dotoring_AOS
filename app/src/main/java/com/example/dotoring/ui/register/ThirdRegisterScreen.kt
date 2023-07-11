package com.example.dotoring.ui.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotoring.R
import com.example.dotoring.ui.register.util.CommonTextField
import com.example.dotoring.ui.register.util.EffectiveCheckButton
import com.example.dotoring.ui.register.util.RegisterScreenNextButton
import com.example.dotoring.ui.register.util.RegisterScreenTop
import com.example.dotoring.ui.theme.DotoringTheme

@Composable
fun ThirdRegisterScreen() {

    var nicknameInput by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 50.dp)
    ) {

        RegisterScreenTop(
            screenNumber = 3,
            question = R.string.register3_q3,
            stringResource(id = R.string.register3_guide)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row() {

            Text(
                stringResource(id = R.string.register_A),
                modifier = Modifier.padding(8.dp)
            )

            Column() {

                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.CenterEnd
                ) {
                    CommonTextField(value = nicknameInput, onValueChange = { nicknameInput = it })

                    EffectiveCheckButton(text = stringResource(id = R.string.register3_nickname_duplication_check))
                }

                Spacer(modifier = Modifier.size(28.dp))

                Text(
                    text = stringResource(R.string.register3_),
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                )
            }


        }

        Spacer(modifier = Modifier.weight(1.5f))

        RegisterScreenNextButton()

        Spacer(modifier = Modifier.weight(10f))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    DotoringTheme {
        ThirdRegisterScreen()
    }
}