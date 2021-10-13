package com.divya_prakash.tictactoe.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// manages turns
class GameManager {
    private val player1 = "Player1"
    private val player2 = "Player2"

    // false mean player2's turn
    private var player1Turn = true
    private val game = TicTacToe()

    private val winnerFound = MutableLiveData<Int>()

    fun makeTouch(row: Int, column: Int): Int {
        var draw = -1
        if(player1Turn)
            draw = game.setCircleAt(row, column)
        else
            draw = game.setCrossAt(row, column)
        val winner = game.findWinner()
        winnerFound.postValue(winner)
        player1Turn = !player1Turn
        return draw
    }

    fun getWinner(): LiveData<Int> {
        return winnerFound
    }

    fun resetGame() {
        player1Turn = true
        winnerFound.value = -1
        game.reset()
    }

}