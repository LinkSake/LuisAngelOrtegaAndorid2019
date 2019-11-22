package android.linksake.luisangel

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class HelloWorld : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensorListener: ShakeEventListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {


        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mSensorListener = ShakeEventListener()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        Log.d("ALL STAR", "hey now!")


        this.mSensorListener!!.setOnShakeListener {
            Toast.makeText(
                this,
                "Shake!!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(
            mSensorListener,
            mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause() {
        mSensorManager!!.unregisterListener(mSensorListener)
        super.onPause()
    }

}
