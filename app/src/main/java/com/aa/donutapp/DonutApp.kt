package com.aa.donutapp

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aa.donutapp.ui.screens.details_screen.DetailsScreen
import com.aa.donutapp.ui.screens.home_screen.HomeScreen
import com.aa.donutapp.ui.screens.splash.SplashScreen
import com.aa.donutapp.ui.theme.DonutAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DonutApp() {
    DonutAppTheme {
        Scaffold {
            val navController = rememberNavController()
           NavHost(navController = navController , startDestination = "splash screen" ){
               composable("home screen"){ HomeScreen(navController)}
               composable("splash screen"){ SplashScreen(navController)}
               composable("details screen"){ DetailsScreen(navController)}
           }
        }
    }
}