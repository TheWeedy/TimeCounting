package com.example.timemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timemanager.config.APProute
import com.example.timemanager.ui.screen.mainnav.MainNavView
import com.example.timemanager.ui.screen.start.StartPageView
import com.example.timemanager.ui.theme.TimeManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeManagerTheme {
                val appNavController= rememberNavController()
                NavHost(navController = appNavController, startDestination = APProute.START_SCREEN){
                    composable(APProute.START_SCREEN){
                        StartPageView(appNavController)
                    }
                    composable(APProute.MAIN_NAV){
                        MainNavView()
                    }
                }
            }
        }
    }
}


