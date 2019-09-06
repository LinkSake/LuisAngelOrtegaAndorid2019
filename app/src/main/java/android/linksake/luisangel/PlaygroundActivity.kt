package android.linksake.luisangel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_playground.*
import java.util.*

class PlaygroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)


        btnLoop.setOnClickListener {
            loop()
        }

    }

    fun loop(){

        val random = Random().nextInt(11)

        Log.d("Rndm: ",random.toString())

        for (i in 1..random) {
            Toast.makeText(this,R.string.hello_world, Toast.LENGTH_SHORT).show()
            Log.d("LOOP: ",i.toString())
        }

    }
}
