package com.example.timemanager.ui.screen.mainnav.dictionary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DicViewModel : ViewModel() {
    private var _dataState = MutableStateFlow(DataState())
    val dataState = _dataState
    private var _timeCounting = MutableStateFlow(TimeCounting())
    val timeCounting = _timeCounting
    private var _wordList = MutableStateFlow(Wordlist())
    val wordList = _wordList

    init {
        initWords()
        updateTime()
    }

    private fun initWords() {

    }

    private fun updateTime() {
        viewModelScope.launch(Dispatchers.IO) {
            _timeCounting.apply {
                while (true) {
                    val nowTime=value.second+1
                    value=value.copy(second = nowTime)
                    delay(1000)
                }
            }
        }
    }
}