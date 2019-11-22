package android.linksake.luisangel

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shake.*
import java.util.*

class ShakeActivity : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensorListener: ShakeEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shake)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mSensorListener = ShakeEventListener()

        this.mSensorListener!!.setOnShakeListener {
            play()
        }

    }

    fun play() {
        val random = Random().nextInt(3)
        when (random) {
            0 -> ivRPS.setImageDrawable(getResources().getDrawable(R.drawable.rock))
            1 -> ivRPS.setImageDrawable(getResources().getDrawable(R.drawable.paper))
            2 -> ivRPS.setImageDrawable(getResources().getDrawable(R.drawable.scissors))
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
