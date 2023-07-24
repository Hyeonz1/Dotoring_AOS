package com.example.dotoring

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import com.example.dotoring.ui.detail.MenteeDetailed
import com.example.dotoring.ui.home.HomeScreen
import com.example.dotoring.ui.message.messageBox.MessageBoxScreen
import com.example.dotoring.ui.message.messageDetail.MessageDetailScreen
import com.example.dotoring.ui.register.RegisterBranchScreen
import com.example.dotoring.ui.register.fifth.FifthRegisterScreen
import com.example.dotoring.ui.register.first.RegisterScreenFirst
import com.example.dotoring.ui.register.fourth.FourthRegisterScreen
import com.example.dotoring.ui.register.second.SecondRegisterScreen
import com.example.dotoring.ui.register.sixth.SixthRegisterScreen
import com.example.dotoring.ui.register.third.ThirdRegisterScreen
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


enum class DotoringScreen() {
    Login,
    Waiting,
    Branch,
    Register1,
    Register2,
    Register3,
    Register4,
    Register5,
    Register6,
    Home,
    UserDetail,
    Message,
    MessageDetail,
    Calendar,
    Mypage
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf<BottomNavScreen> (
        BottomNavScreen.Home,
        BottomNavScreen.Calendar,
        BottomNavScreen.Message,
        BottomNavScreen.Mypage
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFFC6C6C6)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                label = { Text(stringResource(id = item.resourceId), fontSize = 9.sp) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color(0xffc3c3c3),
                selected = currentRoute == item.route,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }

}

/*@Composable
fun DotoringApp(
    registerFirstViewModel: RegisterFirstViewModel = viewModel(),
    registerSecondViewModel: RegisterSecondViewModel = viewModel(),
    registerThirdViewModel: RegisterThirdViewModel = viewModel(),
    registerFourthViewModel: RegisterFourthViewModel = viewModel(),
    registerFifthViewModel: RegisterFifthViewModel = viewModel(),
    registerSixthViewModel: RegisterSixthViewModel = viewModel(),
    messageBoxViewModel: MessageBoxViewModel = viewModel(),
    messageDetailViewModel: MessageDetailViewModel = viewModel()
) {
    val navController = rememberNavController()
}*/

fun NavGraphBuilder.registerGraph(navController: NavController) {
    navigation(startDestination = DotoringScreen.Branch.name, route = DotoringScreen.Login.name) {

        composable(route = DotoringScreen.Branch.name) {
            RegisterBranchScreen()
        }
        composable(route = DotoringScreen.Register1.name) {
            RegisterScreenFirst()
        }
        composable(route = DotoringScreen.Register2.name) {
            SecondRegisterScreen()
        }
        composable(route = DotoringScreen.Register3.name) {
            ThirdRegisterScreen()
        }
        composable(route = DotoringScreen.Register4.name) {
            FourthRegisterScreen()
        }
        composable(route = DotoringScreen.Register5.name) {
            FifthRegisterScreen()
        }
        composable(route = DotoringScreen.Register6.name) {
            SixthRegisterScreen()
        }

    }
}

sealed class BottomNavScreen(val route: String, @StringRes val resourceId: Int, @DrawableRes val icon: Int) {
    object Home : BottomNavScreen(route = DotoringScreen.Home.name, resourceId = R.string.navigation_home, icon = R.drawable.ic_navigation_home)
    object Calendar : BottomNavScreen(route = DotoringScreen.Calendar.name, resourceId = R.string.navigation_calendar, icon = R.drawable.ic_navigation_calendar)
    object Message : BottomNavScreen(route = DotoringScreen.Message.name, resourceId = R.string.navigation_message, icon = R.drawable.ic_navigation_message)
    object Mypage : BottomNavScreen(route = DotoringScreen.Mypage.name, resourceId = R.string.navigation_setting, icon = R.drawable.ic_navigation_mypage)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DotoringScreen.Login.name
    ) {

        registerGraph(navController = navController)

        composable(route = DotoringScreen.Waiting.name) { /*TODO*/ }

        composable(route = DotoringScreen.Home.name) {
            HomeScreen()
        }
        composable(route = DotoringScreen.UserDetail.name) {
            MenteeDetailed()
        }
        composable(route = DotoringScreen.Message.name) {
            MessageBoxScreen()
        }
        composable(route = DotoringScreen.MessageDetail.name) {
            MessageDetailScreen()
        }
        composable(route = DotoringScreen.Calendar.name) { /*TODO*/ }
        composable(route = DotoringScreen.Mypage.name) { /*TODO*/ }

    }
}