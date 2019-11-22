package android.linksake.luisangel

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
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

    var startSound: MediaPlayer? = null
    var endSound: MediaPlayer? = null

    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)

        resetGame()

        timeTextView.text = getString(R.string.time_left, time.toString() )
        scoreTextView.text = getString(R.string.your_score, score.toString())

        btnTapMe.setOnClickListener {
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            it.startAnimation(bounceAnimation)
            incrementScore()
        }

    }

    private fun incrementScore() {
        if(gameStarted === false) {
            startGame()
        }
        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        scoreTextView.startAnimation(fadeAnimation)
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
        startSound = MediaPlayer.create(this, R.raw.game)
        startSound?.start()

    }

    private fun endGame() {
        gameStarted = false
        Toast.makeText(this, getString(R.string.game_over, score.toString()), Toast.LENGTH_LONG).show()
        resetGame()
        startSound?.stop()
        startSound?.release()
        endSound = MediaPlayer.create(this, R.raw.endgame)
        endSound?.start()
    }

}