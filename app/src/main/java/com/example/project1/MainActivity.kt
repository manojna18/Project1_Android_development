package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project1.R.string.draw
import com.example.project1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var playerScore = 0
    private var compScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun changeImageToRock(view: View) {
        binding.playerChoice.setImageResource(R.drawable.rock)


        when (Random.nextInt(1, 4)) {
            1 -> {
                binding.computerChoice.setImageResource(R.drawable.rock)

            }
            2 -> {
                binding.computerChoice.setImageResource(R.drawable.paper)
                updateCompScore()
            }
            3 -> {
                binding.computerChoice.setImageResource(R.drawable.scissors)
                updatePlayerScore()
            }
        }

    }
    fun changeImageToPaper(view: View) {
        binding.playerChoice.setImageResource(R.drawable.paper)


        when (Random.nextInt(1, 4)) {
            1 -> {
                binding.computerChoice.setImageResource(R.drawable.rock)
                updatePlayerScore()
            }
            2 -> {
                binding.computerChoice.setImageResource(R.drawable.paper)

            }
            3 -> {
                binding.computerChoice.setImageResource(R.drawable.scissors)
                updateCompScore()
            }
        }
    }
    fun changeImageToScissors(view: View) {
        binding.playerChoice.setImageResource(R.drawable.scissors)

        when (Random.nextInt(1, 4)) {
            1 -> {
                binding.computerChoice.setImageResource(R.drawable.rock)
                updateCompScore()
            }
            2 -> {
                binding.computerChoice.setImageResource(R.drawable.paper)
                updatePlayerScore()
            }
            3 -> {
                binding.computerChoice.setImageResource(R.drawable.scissors)

            }
        }


    }

    private fun updatePlayerScore(): Int {
        if(playerScore < 10){
            playerScore += 1
            binding.playerScoreVal.text = playerScore.toString()
        }
        if(playerScore >= 10){
            binding.playerScoreVal.text = getString(R.string.winner)
            binding.rock.isEnabled = false
            binding.paper.isEnabled = false
            binding.scissors.isEnabled = false
            binding.restartBtn.visibility = View.VISIBLE
        }
        if(compScore == 10 && playerScore == 10){
            binding.playerScoreVal.text = getString(draw)
            binding.compScoreVal.text = getString(draw)
            binding.rock.isEnabled = false
            binding.paper.isEnabled = false
            binding.scissors.isEnabled = false
            binding.restartBtn.visibility = View.VISIBLE
        }
        return playerScore

    }

    private fun updateCompScore(): Int {
        if(compScore < 10){
            compScore += 1
            binding.compScoreVal.text = compScore.toString()
        }
        if(compScore >= 10){
            binding.compScoreVal.text = getString(R.string.winner)
            binding.rock.isEnabled = false
            binding.paper.isEnabled = false
            binding.scissors.isEnabled = false
            binding.restartBtn.visibility = View.VISIBLE
        }
        if(compScore == 10 && playerScore == 10){
            binding.playerScoreVal.text = getString(draw)
            binding.compScoreVal.text = getString(draw)
            binding.rock.isEnabled = false
            binding.paper.isEnabled = false
            binding.scissors.isEnabled = false
            binding.restartBtn.visibility = View.VISIBLE
        }
        return compScore

    }

    fun restartGame(view: View){
        compScore = 0
        playerScore = 0
        binding.compScoreVal.text = 0.toString()
        binding.playerScoreVal.text = 0.toString()
        binding.rock.isEnabled = true
        binding.paper.isEnabled = true
        binding.scissors.isEnabled = true
        binding.restartBtn.visibility = View.INVISIBLE

    }

}