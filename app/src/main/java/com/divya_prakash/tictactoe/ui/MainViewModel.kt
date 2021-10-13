package com.divya_prakash.tictactoe.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val winner = MutableLiveData<Int>(-1)
    fun getWinner(): LiveData<Int> {
        return winner
    }
}