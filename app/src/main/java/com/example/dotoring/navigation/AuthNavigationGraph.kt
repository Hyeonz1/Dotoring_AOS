package com.example.dotoring.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.dotoring.ui.login.LoginScreen
import com.example.dotoring.ui.register.fifth.FifthRegisterScreen
import com.example.dotoring.ui.register.first.RegisterScreenFirst
import com.example.dotoring.ui.register.fourth.FourthRegisterScreen
import com.example.dotoring.ui.register.second.SecondRegisterScreen
import com.example.dotoring.ui.register.sixth.SixthRegisterScreen
import com.example.dotoring.ui.register.third.ThirdRegisterScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = AuthScreen.Waiting.route) {
            /* TODO */
        }

        composable(route = AuthScreen.Register1.route) {
            RegisterScreenFirst()
        }

        composable(route = AuthScreen.Register2.route) {
            SecondRegisterScreen()
        }

        composable(route = AuthScreen.Register3.route) {
            ThirdRegisterScreen()
        }

        composable(route = AuthScreen.Register4.route) {
            FourthRegisterScreen()
        }

        composable(route = AuthScreen.Register5.route) {
            FifthRegisterScreen()
        }

        composable(route = AuthScreen.Register6.route) {
            SixthRegisterScreen()
        }

    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object Waiting : AuthScreen(route = "WAITING")
    object Register1 : AuthScreen(route = "REGISTER")
    object Register2 : AuthScreen(route = "REGISTER")
    object Register3 : AuthScreen(route = "REGISTER")
    object Register4 : AuthScreen(route = "REGISTER")
    object Register5 : AuthScreen(route = "REGISTER")
    object Register6 : AuthScreen(route = "REGISTER")
}