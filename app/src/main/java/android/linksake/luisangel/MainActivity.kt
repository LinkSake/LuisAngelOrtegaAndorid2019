package android.linksake.luisangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
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

        btnSP.setOnClickListener {
            startActivity(Intent(this, SharedPreferences::class.java))
        }

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("TAG", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                val msg = "El token es $token"
                Log.d("TAG", msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            })

    }
}
