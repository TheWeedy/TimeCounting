package com.example.timemanager.ui.screen.mainnav

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timemanager.R
import com.example.timemanager.config.MAINrout
import com.example.timemanager.config.MAINrout.DIC_SCREEN
import com.example.timemanager.config.MAINrout.MOD_SCREEN
import com.example.timemanager.ui.screen.mainnav.dictionary.DictionaryView
import com.example.timemanager.ui.screen.mainnav.modify.ModifierView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavView() {
    val navlist = listOf<Pair<String, Int>>(
        Pair("词典", R.drawable.dictionary),
        Pair("修改", R.drawable.modify)
    )
    var nowActivateIndex by remember {
        mutableStateOf(0)
    }
    val mainnavcontroller = rememberNavController()

    mainnavcontroller.addOnDestinationChangedListener { _, destination, _ ->
        when (destination.route) {
            DIC_SCREEN -> {
                nowActivateIndex = 0
            }

            MOD_SCREEN -> {
                nowActivateIndex = 1
            }
        }
    }



    Scaffold(
        modifier = Modifier,
        bottomBar = {
            NavigationBar {
                navlist.forEachIndexed { index, pair ->
                    NavigationBarItem(
                        selected = nowActivateIndex == index,
                        onClick = {
                            nowActivateIndex = when (index) {
                                0 -> {
                                    mainnavcontroller.mynavigate(MAINrout.DIC_SCREEN)
                                    index
                                }

                                1 -> {
                                    mainnavcontroller.mynavigate(MAINrout.MOD_SCREEN)
                                    index
                                }

                                else -> {
                                    index
                                }
                            }
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = pair.second),
                                contentDescription = null
                            )
                        },
                        label = { Text(text = pair.first) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedTextColor = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = mainnavcontroller, startDestination = MAINrout.DIC_SCREEN) {
                composable(MAINrout.DIC_SCREEN) {
                    DictionaryView()
                }
                composable(MAINrout.MOD_SCREEN) {
                    ModifierView()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainNavViewPreview() {
    MainNavView()
}

fun NavController.mynavigate(route: String) {
    this.navigate(route) {
        popUpTo(this@mynavigate.graph.findStartDestination().id)
        launchSingleTop = true
    }
}