package com.example.dotoring.ui.message.messageBox

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.navigation.Graph
import com.example.dotoring.navigation.MessageDetailScreen
import com.example.dotoring.network.DotoringAPI
import com.example.dotoring.ui.home.data.Mentee
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageBoxViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MessageBoxUiState())
    val uiState: StateFlow<MessageBoxUiState> = _uiState.asStateFlow()


    fun goToMessageDetailScreen(navController: NavHostController) {
        navController.navigate(MessageDetailScreen.MessageDetailed.route)
    }

    fun renderMessageBoxScreen(navController: NavHostController) {

        //navController.navigate(MessageDetailScreen.MessageDetailed.route)
        val renderMessageBoxRequestCall: Call<CommonResponse> =
            DotoringAPI.retrofitService.loadMessageBox()

        renderMessageBoxRequestCall.enqueue(object : Callback<CommonResponse> {
            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                val jsonObject= Gson().toJson(response.body())
                Log.d("로그인", "로그인??" )
                val jo = JSONObject(jsonObject)
                Log.d("f로그인","로그인 성공할락말락")
                val jsonObjectSuccess = jo.getBoolean("success")


                if (jsonObjectSuccess) {
                    val jsonObjectArray = jo.getJSONArray("response")
                    val uiMessageBoxList: MutableList<MessageBox> = mutableListOf()


                    for (i in 0 until jsonObjectArray.length()) {
                        Log.d("로그인" + " i", i.toString())
                        val getObject = jsonObjectArray.getJSONObject(i)
                        val time=getObject.getString("updateAt")


                        val messagebox = MessageBox(
                            roomPK = getObject.getInt("roomPK"),
                            memberPK = getObject.getInt("memberPK"),
                            nickname = getObject.getString("nickname"),
                            lastLetter = getObject.getString("lastLetter"),
                            updateAt = getObject.getString("updateAt")
                        )

                        uiMessageBoxList.add(messagebox)
                    }

                    _uiState.update { currentState ->
                        currentState.copy(messageList = uiMessageBoxList)
                    }
                }
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                Log.d("메세지박스 통신", "요청 내용 - $renderMessageBoxRequestCall")

            }
        })
  }
}


