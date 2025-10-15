package com.luis.smallnews.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luis.smallnews.presentation.detailScreen.DetailScreen
import com.luis.smallnews.presentation.detailScreen.DetailViewModel
import com.luis.smallnews.presentation.mainScreen.MainScreen

@Composable
fun NavigationComponent(){
    val navController = rememberNavController()
    val detailViewModel:DetailViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.MAIN_SCREEN) {
            MainScreen{ articleModel ->
                detailViewModel.catchArticle(articleModel)
                navController.navigate(Routes.DETAIL_SCREEN)
            }
        }
        composable(Routes.DETAIL_SCREEN) {
            DetailScreen(viewModel = detailViewModel)
        }
    }
}