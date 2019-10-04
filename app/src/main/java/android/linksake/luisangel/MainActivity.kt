package android.linksake.luisangel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHelloWorld.setOnClickListener {
            //val intHelloWorld = Intent(this, HelloWorld::class.java)
            startActivity(Intent(this, HelloWorld::class.java))
        }

        btnTimeFighter.setOnClickListener {
            //val intTimeFighter = Intent(this, TimeFighter::class.java)
            startActivity(Intent(this, TimeFighter::class.java))
        }

        btnFtoC.setOnClickListener {
            startActivity(Intent(this,FtoC::class.java))
        }

        btnDialog.setOnClickListener {
            startActivity(Intent(this,DialogActivity::class.java))
        }

        btnDialogMngt.setOnClickListener {
            startActivity(Intent(this,DialogManagementActivity::class.java))
        }

        btnPlaygorund.setOnClickListener {
            startActivity(Intent(this, PlaygroundActivity::class.java))
        }

        btnTap.setOnClickListener { view ->
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(bounceAnimation)
        }

        btnIMC.setOnClickListener {
            startActivity(Intent(this, imcActivity::class.java))
        }

        btnRPS.setOnClickListener{
            startActivity(Intent(this, ShakeActivity::class.java))
        }

    }
}
