package android.linksake.luisangel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HelloWorld : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        Log.d("ALL STAR", "hey now!")
    }
}
