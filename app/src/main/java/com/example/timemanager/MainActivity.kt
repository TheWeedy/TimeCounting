package com.example.timemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timemanager.ui.theme.TimeManagerTheme
import com.konyaco.fluent.background.Layer
import com.konyaco.fluent.component.*
import com.konyaco.fluent.icons.Icons
import com.konyaco.fluent.icons.filled.Home
import com.konyaco.fluent.icons.filled.ImageSearch
import com.konyaco.fluent.icons.filled.Payment
import com.konyaco.fluent.icons.fluentIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeManagerTheme {
                Layer(modifier = Modifier.fillMaxSize()) {
                    Row {
                        SideNav(
                            modifier = Modifier.fillMaxHeight(),
                            expanded = true,
                            onExpandStateChange = {}) {
                            SideNavItem(selected = true, onClick = {}) {
                                Icon(
                                    imageVector = Icons.Filled.ImageSearch,
                                    contentDescription = null
                                )
                            }
                            SideNavItem(selected = false, onClick = {}) {
                                Icon(imageVector = Icons.Filled.Payment, contentDescription = null)
                            }
                            SideNavItem(selected = false, onClick = {}) {
                                Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                            }
                        }
                        Layer {

                        }
                    }
                }
            }
        }
    }
}


