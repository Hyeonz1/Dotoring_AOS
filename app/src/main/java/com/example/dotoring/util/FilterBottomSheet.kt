package com.example.dotoring.util

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.BackdropValue
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotoring.R
import com.example.dotoring.ui.home.HomeScreen
import com.example.dotoring.ui.theme.DotoringTheme
import com.example.dotoring.util.data.OptionDataSource
import com.example.dotoring.util.data.SelectedDataSource

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun BottomSheetPreview() {
    DotoringTheme() {
        FilterBottomSheet( rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed),{ HomeScreen() }, "직무 분야 선택" )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterBottomSheet(
    scaffoldState: BackdropScaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed),
    backLayerContent: @Composable () -> Unit,
    text: String
) {

    BackdropScaffold(
        appBar = { /*TODO*/ },
        scaffoldState = scaffoldState,
        peekHeight = 360.dp,
        headerHeight = 1.dp,
        backLayerContent = backLayerContent,
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
                            text = text,
                            color = colorResource(id = R.color.white),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.size(width = 180.dp, height = 22.dp))

                        ResetButton(
                            onClick = { SelectedDataSource().clearSelectedData() },
                            text = "초기화",
                        )
                    }

                    Spacer(modifier = Modifier.size(20.dp))

                    Column() {
                        SelectedDataList(
                            selectedDataList = SelectedDataSource().loadSelections())
                    }

                    Spacer(modifier = Modifier.size(30.dp))
                    Column() {
                        OptionDataList(
                            optionDataList = OptionDataSource().loadOptions()
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        },
/*
        persistentAppBar = false,
*/
        frontLayerShape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
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

@Composable
private fun OptionDataList(optionDataList: List<String>) {
    LazyColumn() {
        items(optionDataList) {option ->
            BottomSheetOption(option)
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
private fun SelectedDataList(selectedDataList: List<String>) {
    LazyColumn() {
        items(selectedDataList) {selection ->
            SelectedData(selection)
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}