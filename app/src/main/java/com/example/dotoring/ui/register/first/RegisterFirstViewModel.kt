package com.example.dotoring.ui.register.first

import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.dotoring.util.FilterBottomSheet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterFirstViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(RegisterFirstUiState())
    val uiState: StateFlow<RegisterFirstUiState> = _uiState.asStateFlow()

    fun updateUserCompany(userCompany: String) {
        _uiState.update { currentState ->
            currentState.copy(company = userCompany)
        }
    }

    fun updateCompanyFieldState(emptyField: Boolean) {
        if (emptyField) {
            _uiState.update { currentState ->
                currentState.copy(fillCompanyField = false)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(fillCompanyField = true)
            }
        }
    }

    fun updateUserCareer(userCareer: String) {
        _uiState.update { currentState ->
            currentState.copy(careerLevel = userCareer)
        }
    }

    fun updateCareerFieldState(emptyField: Boolean) {
        if (emptyField) {
            _uiState.update { currentState ->
                currentState.copy(fillCareerField = false)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(fillCareerField = true)
            }
        }
    }

    fun updateUserJob(userJob: String) {
        _uiState.update { currentState ->
            currentState.copy(job = userJob)
        }
    }

    fun updateJobFieldState(emptyField: Boolean) {
        if (emptyField) {
            _uiState.update { currentState ->
                currentState.copy(fillJobField = false)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(fillJobField = true)
            }
        }
    }

    fun updateUserMajor(userMajor: String) {
        _uiState.update { currentState ->
            currentState.copy(major = userMajor)
        }
    }

    fun updateMajorFieldState(emptyField: Boolean) {
        if (emptyField) {
            _uiState.update { currentState ->
                currentState.copy(fillCareerField = false)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(fillCareerField = true)
            }
        }
    }

    fun enableNextButton() {
        _uiState.update { currentState ->
            currentState.copy(firstBtnState = true)
        }
    }


    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun showBottomSheet() {
        FilterBottomSheet(rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed), { RegisterScreenFirst(navController = rememberNavController(
        )) }, "직무 분야 선택")
    }

}