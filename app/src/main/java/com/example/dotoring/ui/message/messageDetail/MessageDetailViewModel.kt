package com.example.dotoring.ui.message.messageDetail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.dotoring.MyApplication
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.dto.login.LoginRequest
import com.example.dotoring.dto.message.MessageRequest
import com.example.dotoring.navigation.Graph
import com.example.dotoring.network.DotoringAPI
import com.example.dotoring.ui.message.messageDetail.data.MessageDetail
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageDetailViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MessageDetailUiState())
    val uiState: StateFlow<MessageDetailUiState> = _uiState.asStateFlow()


    fun updateContent(contentInput: String) {
        _uiState.update { currentState ->
            currentState.copy(content = contentInput)
        }
    }

    fun sendMessage(navController: NavHostController){
        val sendMessageRequest= MessageRequest(content = uiState.value.content)
        val sendMessageRequestCall: Call<CommonResponse> = DotoringAPI.retrofitService.inSendMessage(sendMessageRequest)
        Log.d("통신", "ㅌ통신함수 실행:")

        sendMessageRequestCall.enqueue(object : Callback<CommonResponse>
        {

            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                Log.d("메세지", "통신 성공 : ${response.raw()}")
                Log.d("메세지", "통신 성공 : " + response.body().toString())

                val jsonObject= Gson().toJson(response.body())
                Log.d("메세지","로그인 성공할락말락")
                val jo = JSONObject(jsonObject)
                val jsonObjectSuccess = jo.getBoolean("success")
                Log.d("메세지", "ㅌ통신성공??:")

                if (jsonObjectSuccess) {
                    Log.d("메세지", "ㅌ통신함수 성공:")
                    renderMessageDetailScreen(navController)

                }
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("회원 가입 통신", "요청 내용 - $sendMessageRequestCall")

            }
        })

    }

    fun renderMessageDetailScreen(navController: NavHostController) {

        val renderMessageDetailRequestCall: Call<CommonResponse> =
            DotoringAPI.retrofitService.loadDetailedMessage(roomPk = 1, page=1, size=6 )

        renderMessageDetailRequestCall.enqueue(object : Callback<CommonResponse> {
        override fun onResponse(
            call: Call<CommonResponse>,
            response: Response<CommonResponse>
        ) {
            Log.d("메세지", "통신 성공 : ${response.raw()}")
            Log.d("메세지", "통신 성공 : " + response.body().toString())
            val jsonObject= Gson().toJson(response.body())
            Log.d("메세지","로그인 성공할락말락")
            val jo = JSONObject(jsonObject)
            val jsonObjectSuccess = jo.getBoolean("success")
            Log.d("메세지", "ㅌ통신성공??:")

            if (jsonObjectSuccess) {
               // val jsonObjectArray = jo.getJSONArray("response")
                val uiMessageDetailList: MutableList<MessageDetail> = mutableListOf()
//
//
//                for (i in 0 until jsonObjectArray.length()) {
//                    Log.d("로그인" + " i", i.toString())
//                    val getObject = jsonObjectArray.getJSONObject(i)
//                    val time=getObject.getString("createdAt")
//
//
//                    val messageDetail = MessageDetail(
//                        nickname = getObject.getString("nickname"),
//                        letterId = getObject.getInt("letterId"),
//                        content = getObject.getString("content"),
//                        writer = getObject.getBoolean("writer"),
//                        createdAt = getObject.getString("createdAt")
//                    )

                   //// uiMessageDetailList.add(MessageDetail)
            //    }

                _uiState.update { currentState ->
                    currentState.copy(chatList = uiMessageDetailList)
                }
            }
        }

        override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
            Log.d("통신", "통신 실패: $t")
            Log.d("메세지박스 통신", "요청 내용 - $renderMessageDetailRequestCall")

        }
    })
}
}


