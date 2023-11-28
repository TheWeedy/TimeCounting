package com.example.timemanager.ui.screen.start

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.timemanager.config.APProute
import com.example.timemanager.ui.theme.TimeManagerTheme
import kotlinx.coroutines.delay

@Composable
fun StartPageView(appNavController: NavHostController) {
    LaunchedEffect(key1 = Unit){
        delay(1000)
        appNavController.navigate(APProute.MAIN_NAV)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var contentVisible by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(key1 = Unit) {
            delay(100)
            contentVisible = true
        }
        AnimatedVisibility(
            visible = contentVisible,
            enter = expandVertically(expandFrom = Alignment.Bottom) + fadeIn(initialAlpha = 0.1f)
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Wordlist",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 30.sp
            )
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun StartPageViewPreview() {
//    TimeManagerTheme {
//        StartPageView()
//    }
//}