package com.example.dotoring.ui.message.messageBox

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.dotoring.dto.CommonResponse
import com.example.dotoring.navigation.Graph
import com.example.dotoring.navigation.MessageDetailScreen
import com.example.dotoring.network.DotoringAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageBoxViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MessageBoxUiState())
    val uiState: StateFlow<MessageBoxUiState> = _uiState.asStateFlow()

    fun goToMessageDetailScreen(navController: NavHostController) {
        //navController.navigate(MessageDetailScreen.MessageDetailed.route)
        val goToMessageDetailRequestCall: Call<CommonResponse> =
            DotoringAPI.retrofitService.loadDetailedMessage(page=1, size = 9, roomPk = 2 )

        goToMessageDetailRequestCall.enqueue(object : Callback<CommonResponse> {
            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                val jsonObjectResponse = JSONObject(response.body().toString())
                val jsonObjectSuccess = jsonObjectResponse.getBoolean("success")

                if (jsonObjectSuccess) {
                   navController.navigate(MessageDetailScreen.MessageDetailed.route)
                }
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Log.d("통신", "통신 실패: $t")
                //og.d("회원 가입 통신", "요청 내용 - $sendLoginRequestCall")

            }
        })
  }
}


