package android.linksake.luisangel

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fto_c.*
import kotlinx.android.synthetic.main.activity_main.*

class FtoC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fto_c)

        var etFah = findViewById(R.id.etFah) as EditText
        btnConvert.setOnClickListener {
            var fah = etFah.text.toString().toDouble()
            toCel(fah)
        }

    }

    fun toCel(fahrenheit: Double)  {

        var celsius: Double = (fahrenheit - 32.0) * (5.0/9.0)
        celsius = Math.round(celsius * 100.0) / 100.0
        Toast.makeText(this, getString(R.string.celsius, celsius.toString()), Toast.LENGTH_LONG).show()
        //if(celsius < 10.0) { changeBck() }
    }

    fun changeBck() {
        val colorInt  = getResources().getColor(R.color.FtoC)
        bkg.setBackgroundColor(colorInt)
        Toast.makeText(this, "It's really cold!", Toast.LENGTH_SHORT).show()
    }


}
