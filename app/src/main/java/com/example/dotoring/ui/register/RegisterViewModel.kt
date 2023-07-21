package com.example.dotoring.ui.register

import android.util.Log
import android.widget.Toast
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.dotoring.util.FilterBottomSheet
import kotlinx.coroutines.flow.update


class RegisterViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    var companyInput by mutableStateOf("")
        private set

    var yearInput by mutableStateOf("")
        private set

    var jobInput by mutableStateOf("")
        private set

    var majorInput by mutableStateOf("")
        private set

    var firstBtnState by mutableStateOf(false)
        private set

    fun updateUserCompany(userCompany: String) {
        companyInput = userCompany

        _uiState.update { currentState ->
            currentState.copy(company = userCompany)
        }
    }

    fun updateUserCareer(userCareer: String) {
        yearInput = userCareer

        _uiState.update { currentState ->
            currentState.copy(careerLevel = userCareer)
        }
    }

    fun updateUserJob(userJob: String) {
        jobInput = userJob

        _uiState.update { currentState ->
            currentState.copy(job = userJob)
        }
    }

    fun updateUserMajor(userMajor: String) {
        majorInput = userMajor

        _uiState.update { currentState ->
            currentState.copy(major = userMajor)
        }
    }

    fun enableNextButton() {
       firstBtnState = true
        Log.d("현지", "test")
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun showBottomSheet() {
        FilterBottomSheet(rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed), { RegisterScreenFirst() }, "직무 분야 선택")
    }

}