package com.divya_prakash.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.divya_prakash.tictactoe.core.GameManager
import com.divya_prakash.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val gameManager = GameManager()
    private lateinit var binding: ActivityMainBinding
    private val buttonList = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gameManager.getWinner().observe(this, {
            when (it) {
                -1 -> binding.result.text = ""
                0 -> binding.result.text = "Player1 wins!!"
                1 -> binding.result.text = "Player2 wins!!"
                -2 -> binding.result.text = "Draw!!"
            }
            if (it != -1) binding.reset.visibility = View.VISIBLE
        })
        prepareUI()
    }

    private fun prepareUI() {
        buttonList.add(binding.cell00)
        buttonList.add(binding.cell01)
        buttonList.add(binding.cell02)
        buttonList.add(binding.cell10)
        buttonList.add(binding.cell11)
        buttonList.add(binding.cell12)
        buttonList.add(binding.cell20)
        buttonList.add(binding.cell21)
        buttonList.add(binding.cell22)
        buttonList.map { it.setOnClickListener(this)  }
        binding.reset.setOnClickListener(this)
    }

    private fun resetClick() {
        buttonList.map {
            it.isClickable = true
            it.text = ""
        }
    }

    // email at shivam.jha@likeminds.community

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.cell00.id -> {
                val value = gameManager.makeTouch(0, 0)
                binding.cell00.text = value.toString()
                binding.cell00.isClickable = false
            }

            binding.cell01.id -> {
                val value = gameManager.makeTouch(0, 1)
                binding.cell01.text = value.toString()
                binding.cell01.isClickable = false
            }

            binding.cell02.id -> {
                val value = gameManager.makeTouch(0, 2)
                binding.cell02.text = value.toString()
                binding.cell02.isClickable = false
            }

            binding.cell10.id -> {
                val value = gameManager.makeTouch(1, 0)
                binding.cell10.text = value.toString()
                binding.cell10.isClickable = false
            }

            binding.cell11.id -> {
                val value = gameManager.makeTouch(1, 1)
                binding.cell11.text = value.toString()
                binding.cell11.isClickable = false
            }
            binding.cell12.id -> {
                val value = gameManager.makeTouch(1, 2)
                binding.cell12.text = value.toString()
                binding.cell12.isClickable = false
            }
            binding.cell20.id -> {
                val value = gameManager.makeTouch(2, 0)
                binding.cell20.text = value.toString()
                binding.cell20.isClickable = false
            }
            binding.cell21.id -> {
                val value = gameManager.makeTouch(2, 1)
                binding.cell21.text = value.toString()
                binding.cell21.isClickable = false
            }
            binding.cell22.id -> {
                val value = gameManager.makeTouch(2, 2)
                binding.cell22.text = value.toString()
                binding.cell22.isClickable = false
            }
            binding.reset.id -> {
                gameManager.resetGame()
                binding.reset.visibility = View.INVISIBLE
                resetClick()
            }
        }

    }
}