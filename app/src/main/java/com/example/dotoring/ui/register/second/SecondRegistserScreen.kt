package com.example.dotoring.ui.register.second

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dotoring.R
import com.example.dotoring.navigation.AuthScreen
import com.example.dotoring.ui.register.util.RegisterScreenNextButton
import com.example.dotoring.ui.register.util.RegisterScreenTop
import com.example.dotoring.ui.theme.DotoringTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import de.charlex.compose.HtmlText



/*@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun RequirePermission() {
    val filePermissionState = rememberPermissionState(
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    if (filePermissionState.status.isGranted) {
        Log.d("권한", "filePermissionState 허용")
    } else {
        Log.d("권한", "filePermissionState 비허용")
//        filePermissionState.launchPermissionRequest()
    }
}*/

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun ImageUploadButton(
    registerSecondViewModel: RegisterSecondViewModel = viewModel(),
    uploadEmploymentFile: Boolean
) {

    val registerSecondUiState by registerSecondViewModel.uiState.collectAsState()

    var selectedUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        uri -> selectedUri = uri

        val file = registerSecondViewModel.uriToFile(uri)

        Log.d("파일", "file: $file")

        if(uploadEmploymentFile) {
            registerSecondViewModel.uploadEmploymentFile()
            registerSecondViewModel.updateEmploymentCertification(file)
        } else {
            registerSecondViewModel.uploadGraduationFile()
            registerSecondViewModel.updateGraduationCertification(file)
        }
    }


/*    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument(),
        onResult = {
                uri ->
            selectedUri = uri
            val file = registerSecondViewModel.uriToFile(uri)

            if (uploadEmploymentFile) {
                registerSecondViewModel.uploadEmploymentFile()
                registerSecondViewModel.updateEmploymentCertification(file)
                Log.d("선택", "uploadEmploymentFile == true: $file")

            } else {
                registerSecondViewModel.uploadGraduationFile()
                registerSecondViewModel.updateGraduationCertification(file)
            }


        }
    )*/

    Button(
        onClick = {
                  launcher.launch("*/*")
            /*singlePhotoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )*/
            /*if (filePermissionState.status.isGranted) {
                Log.d("권한", "filePermissionState 허용")
            } else {
                Log.d("권한", "filePermissionState 비허용")
                filePermissionState.launchPermissionRequest()
                Log.d("권한", "launchPermissionRequest")

            }*/
                  },
        modifier = Modifier.size(width = 300.dp, height = 80.dp),
        border = BorderStroke(width = 0.5.dp, color = colorResource(id = R.color.grey_200)),
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(id = R.color.black),
            backgroundColor = colorResource(id = R.color.white),
            disabledBackgroundColor = colorResource(id = R.color.white),
            disabledContentColor = colorResource(id = R.color.black)
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = stringResource(id = R.string.register2_upload_extension))
    }
}

@Composable
fun SecondRegisterScreen(
    navController: NavHostController,
    registerSecondViewModel: RegisterSecondViewModel = viewModel(),
) {

    Column(
        modifier = Modifier.padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisterScreenTop(screenNumber = 2, question = R.string.register2_q2)

        Spacer(modifier = Modifier.padding(35.dp))

        Column {
            HtmlText(
                textId = R.string.register2_upload_certificate_of_employment,
                fontSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            ImageUploadButton(uploadEmploymentFile = true)

            Spacer(modifier = Modifier.size(50.dp))

            Row(verticalAlignment = Alignment.Bottom) {

                HtmlText(
                    textId = R.string.register2_upload_certificate_of_graduate,
                    fontSize = 18.sp)
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = stringResource(id = R.string.register2_upload_choice),
                    fontSize = 13.sp)
            }

            Spacer(modifier = Modifier.size(10.dp))

            ImageUploadButton(uploadEmploymentFile = false)

            Spacer(modifier = Modifier.size(60.dp))

            RegisterScreenNextButton(onClick = { navController.navigate(AuthScreen.Register3.route)}, enabled = true )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    DotoringTheme {
        SecondRegisterScreen(navController = rememberNavController())
    }
}