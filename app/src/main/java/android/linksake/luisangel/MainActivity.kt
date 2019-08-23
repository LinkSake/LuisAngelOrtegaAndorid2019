package android.linksake.luisangel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

    }
}
