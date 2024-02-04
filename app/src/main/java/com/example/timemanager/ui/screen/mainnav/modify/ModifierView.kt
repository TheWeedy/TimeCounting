package com.example.timemanager.ui.screen.mainnav.modify

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.timemanager.entity.AppDatabase
import com.example.timemanager.ui.screen.mainnav.dictionary.Wordlist

@Composable
fun ModifierView() {

    Singleadd()
}

@Composable
fun Singleadd() {
    val mContext = LocalContext.current
    val db=AppDatabase.getDB(mContext)
    val userDao = db.userDao()
    val users: List<Wordlist> = userDao.getAll()
    var text by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            label = { Text("Word") }
        )
        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(15.dp)) {
            Text(text = "ADD")
        }
    }
}


@Composable
fun Multiadd() {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(15.dp),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "格式生成")
            }
            Button(
                onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "添加单词")
            }
        }

        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(15.dp),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ModifierViewPreview() {
    ModifierView()
}