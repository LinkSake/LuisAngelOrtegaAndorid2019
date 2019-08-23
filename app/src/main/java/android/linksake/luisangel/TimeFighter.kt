package android.linksake.luisangel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_time_fighter.*

class TimeFighter : AppCompatActivity() {

    var score = 0
    var time = 60
    var gameStarted = false

    val initialCountDown: Long = 6000
    val countDownInterval: Long = 1000

    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)

        resetGame()

        timeTextView.text = getString(R.string.time_left, time.toString() )
        scoreTextView.text = getString(R.string.your_score, score.toString())

        btnTapMe.setOnClickListener {
            incrementScore()
        }

    }

    private fun incrementScore() {
        if(gameStarted === false) {
            startGame()
        }
        score++
        val newScore = getString(R.string.your_score, score.toString())
        scoreTextView.text = newScore
    }

    private fun resetGame(){
        score = 0
        scoreTextView.text = getString(R.string.your_score, score.toString())
        val initialTimeLeft = initialCountDown / 1000
        timeTextView.text = getString(R.string.time_left, initialTimeLeft.toString())

        countDownTimer = object: CountDownTimer(initialCountDown, countDownInterval){
            override fun onFinish() {
                endGame()
            }

            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timeTextView.text = getString(R.string.time_left, timeLeft.toString())
            }
        }
    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame() {
        gameStarted = false
        Toast.makeText(this, getString(R.string.game_over, score.toString()), Toast.LENGTH_LONG).show()
        resetGame()
    }

}