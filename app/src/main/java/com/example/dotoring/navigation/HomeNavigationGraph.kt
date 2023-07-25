package com.example.dotoring.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dotoring.BottomNavScreen
import com.example.dotoring.ui.detail.MenteeDetailed
import com.example.dotoring.ui.home.MainScreen
import com.example.dotoring.ui.message.messageBox.MessageBoxScreen
import com.example.dotoring.ui.message.messageDetail.MessageDetailScreen

@Composable
fun HomeNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavScreen.Home.route
    ) {
        composable(route = BottomNavScreen.Home.route) {
            MainScreen(navController = navController)
        }

        composable(route = BottomNavScreen.Calendar.route) {

        }
        composable(route = BottomNavScreen.Message.route) {
            MessageBoxScreen(navController = navController)
        }

        composable(route = BottomNavScreen.Mypage.route) {

        }

        mentiDetailNavGraph(navController)

        messageDetailNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.mentiDetailNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.MENTI_DETAILS,
        startDestination = MentiDetailScreen.MentiDetailed.route
    ) {
        composable(route = MentiDetailScreen.MentiDetailed.route) {
            MenteeDetailed(navController = navController)
        }
    }
}

fun NavGraphBuilder.messageDetailNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.MESSAGE_DETAILS,
        startDestination = MessageDetailScreen.MessageDetailed.route
    ) {
        composable(route = MessageDetailScreen.MessageDetailed.route) {
            MessageDetailScreen(navController = navController)
        }
    }
}

sealed class MessageDetailScreen(val route: String) {
    object MessageDetailed: MessageDetailScreen(route = "MESSAGE_DETAILED")
}

sealed class MentiDetailScreen(val route: String) {
    object MentiDetailed: MentiDetailScreen(route = "MENTI_DETAILED")
}