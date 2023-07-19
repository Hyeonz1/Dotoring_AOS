package com.example.dotoring.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.indicatorLine
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.home.HomeScreen
import com.example.dotoring.ui.theme.DotoringTheme

@Preview
@Composable
fun BottomSheetPreview() {
    DotoringTheme() {
        FilterBottomSheet()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterBottomSheet() {

    BackdropScaffold(
        appBar = { /*TODO*/ },
        scaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed),
        peekHeight = 360.dp,
        headerHeight = 1.dp,
        backLayerContent = {  HomeScreen() },
        frontLayerContent = {
            Row(
                modifier = Modifier.padding(top = 30.dp)

            ) {
                Spacer(modifier = Modifier.weight(1f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Text(
                            text = stringResource(id = R.string.bottom_sheet_major_filter),
                            color = colorResource(id = R.color.white),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.size(width = 156.dp, height = 22.dp))

                        ResetButton(
                            onClick = {},
                            text = "초기화",
                        )
                    }

                    Column() {
                        ChoosenFilteredTextField(value = "선택된 학과1", onValueChange = { })
                    }
                    Column() {
                        FilteredTextField(value = "학과1", onValueChange = {} )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        },
        persistentAppBar = false,
        frontLayerShape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        backLayerBackgroundColor = Color(0xffffffff),
        backLayerContentColor = Color(0xff000000),
        frontLayerBackgroundColor = colorResource(id = R.color.green),
        frontLayerScrimColor = Color(0xffffffff)
    ) {
        
    }
}

@Composable
fun ResetButton(onClick: () -> Unit, text: String) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .size(width = 53.dp, height = 20.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp,
        ),
        shape = RoundedCornerShape(30.dp),
        border = BorderStroke(width = 0.5.dp, color = Color(0xff42691A)),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xff42691A),
            backgroundColor = Color(0x0042691A),
            disabledBackgroundColor = Color(0x0042691A),
            disabledContentColor = Color(0xff42691A)
        ),
        contentPadding = PaddingValues(
            start = 3.dp,
            top = 3.dp,
            end = 3.dp,
            bottom = 3.dp
        )
    ){
        Text(
            text = text,
            fontSize = 11.sp,
            letterSpacing = 1.sp)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ChoosenFilteredTextField(value: String, onValueChange: (String) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        contentAlignment = Alignment.CenterEnd
    ) {

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(20.dp)
                )
                .size(width = 330.dp, height = 36.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 15.sp),
            enabled = false,
            readOnly = true,
        ) {
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                innerTextField = it,
                enabled = false,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource =  interactionSource,
                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                    start = 20.dp, top = 1.dp, end = 1.dp, bottom = 3.dp
                )
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_cancel),
                contentDescription = "취소 버튼",
                modifier = Modifier.size(15.dp),
                tint = Color(0xffA5A5A5))
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun FilteredTextField(value: String, onValueChange: (String) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

    val colors = TextFieldDefaults.textFieldColors(
        textColor = colorResource(id = R.color.white),
        focusedIndicatorColor = colorResource(id = R.color.white),
        unfocusedIndicatorColor = colorResource(id = R.color.white),
        backgroundColor = Color(0x00ffffff),
        placeholderColor = colorResource(id = R.color.white)
    )

    Box(
        contentAlignment = Alignment.CenterEnd
    ) {

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(
                    color = Color(0x00ffffff)
                )
                .size(width = 330.dp, height = 36.dp)
                .indicatorLine(
                    enabled = false,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = colors,
                    focusedIndicatorLineThickness = 1.dp,
                    unfocusedIndicatorLineThickness = 1.dp
                ),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 15.sp,
                color = colorResource(id = R.color.white)),
            enabled = false,
            readOnly = true,
        ) {
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                innerTextField = it,
                enabled = false,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource =  interactionSource,
                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                    start = 20.dp, top = 1.dp, end = 1.dp, bottom = 3.dp
                )
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_choose),
                contentDescription = "선택 버튼",
                modifier = Modifier.size(20.dp),
                tint = Color(0xffffffff)
            )
        }
    }
}