package com.example.timemanager.ui.screen.mainnav.dictionary

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.timemanager.entity.AppDatabase
import com.example.timemanager.entity.UserEntity
import java.nio.file.WatchEvent
import java.util.Dictionary
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryView(mynavigation:NavController) {
    val dicViewModel: DicViewModel = viewModel()
    val wordlist by dicViewModel.wordList.collectAsState()
    val timecounting by dicViewModel.timeCounting.collectAsState()
    val mContextDic = LocalContext.current
    val db= AppDatabase.getDB(mContextDic)
    val userDao = db.userDao()
    val users: List<UserEntity> = userDao.getAll()
    //返回监听
    val backPressed = remember { mutableLongStateOf(0L) }
    BackHandler(onBack = {
        if (backPressed.longValue + 2000 > System.currentTimeMillis()) {
            //mynavigation.navigateUp()
            exitProcess(0)
        } else {
            Toast
                .makeText(mContextDic, "再按一次退出", Toast.LENGTH_SHORT)
                .show()
            backPressed.longValue = System.currentTimeMillis()
        }
    })

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 15.dp)) {
                        Button(shape = MaterialTheme.shapes.small, onClick = { /*TODO*/ }) {
                            Text(text = "Start")
                        }
                        Button(shape = MaterialTheme.shapes.small, onClick = { /*TODO*/ }) {
                            Text(text = timecounting.second.toString())
                        }
                    }
                })
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                LazyColumn {
                    items(users){
                    }
                }
            }
        }
    }
}

@Composable
fun WordlistCard(word: String) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .padding(vertical = 3.dp, horizontal = 15.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(mContext, word, Toast.LENGTH_SHORT)
                    .show()
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Text(
            text = word,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
        )
    }
}


//@Preview
//@Composable
//fun DictionaryPreview() {
//    DictionaryView()
//}