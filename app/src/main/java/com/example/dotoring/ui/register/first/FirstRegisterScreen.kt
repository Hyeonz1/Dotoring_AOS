package com.example.dotoring.ui.register.first


import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dotoring.R
import com.example.dotoring.ui.register.util.RegisterScreenTop
import com.example.dotoring.ui.register.util.RegisterScreenNextButton
import com.example.dotoring.ui.theme.DotoringTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dotoring.util.FilterBottomSheet


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Introduce( registerFirstViewModel: RegisterFirstViewModel = viewModel() ) {
    val registerFirstUiState by registerFirstViewModel.uiState.collectAsState()
    val context = LocalContext.current

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Text(
                text = stringResource(id = R.string.register1_im),
                modifier = Modifier.padding(top = 10.dp),
                fontSize = 18.sp)

            Spacer(modifier = Modifier.size(25.dp))

            Column() {
                Column() {
                    IntroduceContent(
                        value = registerFirstUiState.company,
                        onValueChange = { registerFirstViewModel.updateUserCompany(it) },
                        placeholder = stringResource(id = R.string.register1_company),
                        text = stringResource(R.string.register1_belong_to),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                            FocusDirection.Next)}),
                        readOnly = false
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    IntroduceContent(
                        value = registerFirstUiState.careerLevel,
                        onValueChange = { registerFirstViewModel.updateUserCareer(it) },
                        placeholder = stringResource(id = R.string.register1_years),
                        text = stringResource(R.string.register1_years_of_experience),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                            FocusDirection.Next) }),
                        readOnly = false
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    IntroduceContent(
                        value = registerFirstUiState.job,
                        onValueChange = { registerFirstViewModel.updateUserJob(it)},
                        placeholder = stringResource(id = R.string.register1_work),
                        text = stringResource(R.string.register1_),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(
                            FocusDirection.Next) }),
                        readOnly = false
                    )
                }

                Spacer(modifier = Modifier.size(18.dp))

                Column(
                ) {
                    Text(
                        text = stringResource(id = R.string.register1_majored),
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    IntroduceContent(
                        value = registerFirstUiState.major,
                        onValueChange = {  registerFirstViewModel.updateUserMajor(it)},
                        placeholder = stringResource(id = R.string.register1_major),
                        text = stringResource(id = R.string.register1_go),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = { registerFirstViewModel.enableNextButton()
                                focusManager.clearFocus()}),
                        readOnly = false,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun IntroduceContent(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    text: String,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    readOnly: Boolean,
    ) {
    val interactionSource = remember { MutableInteractionSource() }

    val colors = TextFieldDefaults.textFieldColors(
        textColor = colorResource(id = R.color.black),
        focusedIndicatorColor = colorResource(id = R.color.black),
        unfocusedIndicatorColor = colorResource(id = R.color.black),
        backgroundColor = colorResource(id = R.color.white),
        placeholderColor = colorResource(id = R.color.grey_500)
    )

    Row(verticalAlignment = Alignment.CenterVertically) {

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .background(
                    color = colorResource(R.color.white),
                    shape = TextFieldDefaults.TextFieldShape
                )
                .indicatorLine(
                    enabled = true,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = colors
                ),
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            enabled = true,
            singleLine = true,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            readOnly = readOnly
        ) {
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                visualTransformation = VisualTransformation.None,
                innerTextField = it,
                singleLine = true,
                enabled = true,
                // same interaction source as the one passed to BasicTextField to read focus state
                // for text field styling
                placeholder = {
                    Text(
                    text = placeholder,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center)
                },
                colors = colors,
                interactionSource = interactionSource,
                // keep vertical paddings but change the horizontal
                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                    start = 2.dp, top = 1.dp, end = 1.dp, bottom = 3.dp
                )
            )
        }

        Spacer(modifier = Modifier.size(25.dp))

        Text(
            text = text,
            fontSize = 18.sp)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RegisterScreenFirst(
    registerFirstViewModel: RegisterFirstViewModel = viewModel(),
    navController: NavHostController
) {

    val firstNextBtnState = registerFirstViewModel.firstBtnState

    FilterBottomSheet(backLayerContent = {
        Column(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegisterScreenTop(1, R.string.register1_q1)

            Spacer(modifier = Modifier.size(100.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Introduce(
                    registerFirstViewModel
                )

                Spacer(modifier = Modifier.size(100.dp))

                RegisterScreenNextButton(onClick = {}, enabled = firstNextBtnState)
            }

        }
    }, text = "직무 필터 선택")
    // HtmlText(textId = R.string.register_title)
}


@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    DotoringTheme {
        RegisterScreenFirst(navController = rememberNavController())
    }
}