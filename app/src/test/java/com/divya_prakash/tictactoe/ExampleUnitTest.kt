package com.divya_prakash.tictactoe

import com.divya_prakash.tictactoe.core.TicTacToe
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val ticTacToe = TicTacToe()

    @After
    fun clearGame() {
        ticTacToe.reset()
    }

    @Test
    fun `check if tic tac toe finds winner in row`() {
        /**
         *  0  0  0
         * -1  1  1
         *  1 -1 -1
         */

        ticTacToe.setCircleAt(0,0)
        ticTacToe.setCircleAt(0,1)
        ticTacToe.setCircleAt(0, 2)
        ticTacToe.setCrossAt(1,1)
        ticTacToe.setCrossAt(1,2)
        ticTacToe.setCrossAt(2,0)

        assertEquals(0, ticTacToe.findWinner())

    }

    @Test
    fun `check if tic tac toe finds winner in column`() {
        /**
         *  0  1  -1
         * -1  1   0
         *  0  1  -1
         */

        ticTacToe.setCircleAt(0,0)
        ticTacToe.setCircleAt(2,0)
        ticTacToe.setCircleAt(1, 2)

        ticTacToe.setCrossAt(0,1)
        ticTacToe.setCrossAt(1,1)
        ticTacToe.setCrossAt(2,1)

        assertEquals(1, ticTacToe.findWinner())

    }

//    @Test
//    fun `check if tic tac toe finds winner in forward diagonal`() {
//
//    }
//
//    @Test
//    fun `check if tic tac toe finds winner in backward diagonal`() {
//
//    }
//
//    @Test
//    fun `check if tic tac toe finds winner on empty board`() {
//
//    }
//
//    @Test
//    fun `check if tic tac toe finds winner in no winning condition`() {
//
//    }

    @Test
    fun `check if tic tac toe finds winner in draw`() {
        /**
         *  0  1   1
         *  1  0   0
         *  0  0   1
         */

        ticTacToe.setCircleAt(0,0)
        ticTacToe.setCircleAt(1,1)
        ticTacToe.setCircleAt(1, 2)
        ticTacToe.setCircleAt(2, 0)
        ticTacToe.setCircleAt(2, 1)

        ticTacToe.setCrossAt(0,1)
        ticTacToe.setCrossAt(0,2)
        ticTacToe.setCrossAt(1,0)
        ticTacToe.setCrossAt(2,2)

        assertEquals(-2, ticTacToe.findWinner())
    }


}