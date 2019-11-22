package android.linksake.luisangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_playground.*
import java.util.*

class PlaygroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)

        btnShowToast.setOnClickListener {
            play()
        }

        btnLoop.setOnClickListener {
            loop()
        }

    }

    fun play(){

        val date = Pair(5, 22)
        val (day, month) = date
        val dayOfMonth = Triple(29, 8, 2019)

        Toast.makeText(this, "${date}", Toast.LENGTH_LONG).show()
        Handler().postDelayed({
            Toast.makeText(this, "month = ${month} day = ${day} ", Toast.LENGTH_SHORT).show()
        }, 2000)
        Handler().postDelayed({
            Toast.makeText(this, "${dayOfMonth}", Toast.LENGTH_SHORT).show()
        }, 4000)
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
