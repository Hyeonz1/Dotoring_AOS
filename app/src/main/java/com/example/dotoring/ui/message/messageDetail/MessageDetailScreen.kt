package com.example.dotoring.ui.message.messageDetail

import android.graphics.Paint.Align
import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.BackdropValue
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dotoring.R
import com.example.dotoring.ui.register.first.RegisterFirstViewModel
import com.example.dotoring.ui.theme.DotoringTheme
import com.example.dotoring.ui.theme.Gray
import com.example.dotoring.ui.theme.Green
import com.example.dotoring.ui.theme.Navy
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MessageDetailScreen(messageDetailViewModel: MessageDetailViewModel = viewModel()) {
    var message by remember { mutableStateOf("") }
    val writer=true
    val messageDetailUiState by messageDetailViewModel.uiState.collectAsState()
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)

    BackdropScaffold(
        scaffoldState = scaffoldState,
        backLayerBackgroundColor = Color.White,
        peekHeight = 200.dp,
        modifier = Modifier,
        appBar = {},
        backLayerContent = {
            Box() {
                Column(modifier = Modifier) {
                    Surface(
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                            .shadow(
                                elevation = 10.dp,
                                spotColor = Color(0x99000000),
                                ambientColor = Color(0x50000000)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(25.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(70.dp)
                                    .border(
                                        width = 5.dp,
                                        color = colorResource(id = R.color.white),
                                        shape = CircleShape


                                    )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.profile),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                )

                            }
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                            ) {
                                Text(text = "닉네임 들어갈 자리")
                                Text(text = "학과")

                            }
                        }

                    }

                    Column(
                        Modifier
                            .background(Color.White)
                            .padding(5.dp)) {
                        val scrollState = rememberLazyListState()
                        LazyColumn(state = scrollState) {
                            items(3) {
                                    if(writer)
                                    {MentoChatBox(text = "gg")}
                                    else{MentiChatBox("안녕! 나는 수미야\n하이\n ㅎㅎ")}


                                //id가 멘토면 MentoChatBox, 멘티면 MentiChatBox로 만들어지게끔 구현


                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .align(BottomEnd)
                ) {
                    MessageButton(scaffoldState)
                }
            }

        },
        frontLayerContent = {
            Box(modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(top = 15.dp, bottom = 45.dp)) {
                Surface(modifier = Modifier
                    .width(100.dp)
                    .height(5.dp)
                    .align(TopCenter), shape = RoundedCornerShape(40.dp),
                    color = Color.Gray){}
                Text(modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.TopCenter), color = Color.Gray, text = stringResource(id = R.string.message_info ), fontSize = 12.sp)
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, start = 25.dp, end = 25.dp)
                        .align(Alignment.TopCenter)
                        .background(Color.White),
                    shape = RoundedCornerShape(35.dp),
                ) {
                    MessageField(value = message, onValueChange = {message = it}, textField = stringResource(id = R.string.message_textField)
                    )
                }


                Box(
                    modifier = Modifier
                        .align(BottomEnd)
                ) {
                    MessageButton(scaffoldState)
                }
            }


        }
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MessageField(value:String, onValueChange:(String)->Unit, textField: String) {
    Column(modifier = Modifier
        .background(color= Gray)) {
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(
                text = textField,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.black),
                focusedIndicatorColor = Gray,
                unfocusedIndicatorColor = Gray,
                backgroundColor = Gray,
                placeholderColor = Color.Black),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
        )
        Button(modifier = Modifier
            .padding(10.dp)
            .width(40.dp)
            .height(40.dp)
            .align(End)
            , shape = RoundedCornerShape(30.dp),
            onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(R.drawable.send_active),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

    }
}




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MessageButton(scaffoldState: BackdropScaffoldState) {
    val scope = rememberCoroutineScope()
    Button(shape = CircleShape,
        modifier = Modifier
            .size(110.dp)
            .padding(20.dp),
        onClick = {
            if(scaffoldState.currentValue==BackdropValue.Concealed)
            { scope.launch { scaffoldState.reveal() }}
            else
            { scope.launch { scaffoldState.conceal() }}
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Navy)
    ) {
        if(scaffoldState.currentValue==BackdropValue.Concealed)
        {
        Image(
            painter = painterResource(R.drawable.chatting),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize())}
        else{Image(
            painter = painterResource(R.drawable.message),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize())}}
    }


//text: String, name: String, time: String
@Composable
fun MentiChatBox(text:String) {
    Box(Modifier.padding(7.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth(),
            shape= RoundedCornerShape(35.dp),
            color = Navy
        ) {
            Box() {
                Text(modifier = Modifier.padding(start = 25.dp, top=7.dp, end=25.dp),text = "닉네임", color = Color.White, fontSize = 15.sp)
                Text(modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(start = 25.dp, top = 15.dp, end = 25.dp),text = "00월00일 00시00분", color = Color.White, fontSize = 10.sp)

            }
            Surface(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .align(Alignment.BottomCenter),
                shape= RoundedCornerShape(35.dp),
                color = Gray) {
                Text(modifier = Modifier.padding(20.dp), text=text, color= Color.Black)

            }
        }
    }
}
@Composable
fun MentoChatBox(text:String) {
    Box(Modifier.padding(7.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth(),
            shape= RoundedCornerShape(35.dp),
            color = Green
        ) {
            Box() {
                Text(modifier = Modifier.padding(start = 25.dp, top=7.dp, end=25.dp),text = "닉네임", color = Color.White, fontSize = 15.sp)
                Text(modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(start = 25.dp, top = 15.dp, end = 25.dp),text = "00월00일 00시00분", color = Color.White, fontSize = 10.sp)

            }
            Surface(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .align(Alignment.BottomCenter),
                shape= RoundedCornerShape(35.dp),
                color = Gray) {
                Text(modifier = Modifier.padding(20.dp), text=text, color= Color.Black)

            }
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun MessageDetailPreview() {
    DotoringTheme {
        MessageDetailScreen()
    }
}

