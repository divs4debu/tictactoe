package com.divya_prakash.tictactoe.core

import androidx.annotation.IntRange
import java.lang.IllegalArgumentException

class TicTacToe {
    /**
     * GameMatrix is build keeping in mind that first array in gameMatrix show first row
     */
    private val gameMatrix = ArrayList<ArrayList<Int>>(3)
    private val CIRCLE: Int = 0 // TODO: 13/10/2021 Convert to const
    private val CROSS: Int = 1 // TODO: 13/10/2021 Convert to const
    private val DEFAULT: Int = -1
    private val DRAW: Int = -2
    private var turnCounter = 0

    init {
        // Init gameMatrix with -1
        prepareGame()

    }

    private fun prepareGame() {
        for (i in 0 until 3) {
            gameMatrix.add(arrayListOf(-1, -1, -1))
        }
    }

    fun setCrossAt(@IntRange(from=0, to=3) row: Int, @IntRange(from=0, to=3) column:Int):Int {
        val cellValue = gameMatrix[row][column]
        if(cellValue != -1) throw IllegalArgumentException("Cannot set value at $row $column")
        gameMatrix[row][column] = CROSS
        turnCounter++
        return CROSS
    }

    fun setCircleAt(@IntRange(from=0, to=3) row: Int, @IntRange(from=0, to=3) column:Int):Int {
        val cellValue = gameMatrix[row][column]
        if(cellValue != -1) throw IllegalArgumentException("Cannot set value at $row $column")
        gameMatrix[row][column] = CIRCLE
        turnCounter++
        return CIRCLE
    }

    fun findWinner(): Int {
        // check for horizontal
        for(i in 0 until 3) {
            val checkResult = rowCheck(i)
            if(checkResult == CROSS) return CROSS
            else if(checkResult == CIRCLE) return CIRCLE
        }

        // check for vertical
        for (i in 0 until 3) {
            val checkResult = columnCheck(i)
            if(checkResult == CROSS) return CROSS
            else if(checkResult == CIRCLE) return CIRCLE
        }

        // check for both diagonal i.e (0,0) - (2,2) and (0,2) (1,1) (2,0)
        // forward diagonal (0,2) (1,1) (2,0)
        val forwardDiagonalResult = checkForwardDiagonal()
        if(forwardDiagonalResult == CIRCLE) return CIRCLE
        else if(forwardDiagonalResult == CROSS) return CROSS

        // backward diagonal (0,0) (1,1) (2,2)

//        val backwardDiagonalResult =  checkBackwardDiagonal()
//        if(backwardDiagonalResult == CIRCLE) return CIRCLE
//        else if(backwardDiagonalResult == CROSS) return CROSS

        return if(turnCounter != 9)
            checkBackwardDiagonal()
        else
            DRAW

    }

    fun reset() {
        turnCounter = 0
        for(i in 0 until 3)
            for(j in 0 until 3)
                gameMatrix[i][j] = -1
    }

    private fun rowCheck(row:Int):Int {
        val start = gameMatrix[row][0]
        for (i in 1 until 3) {
            if(start != gameMatrix[row][i]) return -1
        }
        return start
    }

    private fun columnCheck(column: Int): Int{
        val start = gameMatrix[0][column]
        for(i in 1 until 3) {
            if(start != gameMatrix[i][column]) return -1
        }
        return start
    }

    private fun checkBackwardDiagonal(): Int {
        val start = gameMatrix[0][0]
        for(i in 1 until 3) {
            if(gameMatrix[i][i] != start) return -1
        }
        return start
    }

    private fun checkForwardDiagonal(): Int {
        val start = gameMatrix[0][2]
        for(i in 1 until 3) {
            if(gameMatrix[i][2-i] != start) return -1
        }
        return start
    }
}