package android.linksake.luisangel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog_management.*
import kotlinx.android.synthetic.main.dialog_image.view.*
import kotlinx.android.synthetic.main.dialog_quit.view.*
import kotlinx.android.synthetic.main.login_dialog.*
import kotlin.system.exitProcess

class DialogManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_management)

        btnShowImg.setOnClickListener {
            val DialogView = layoutInflater.inflate(R.layout.dialog_image, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(DialogView).setTitle("Image Dialog").show()
            DialogView.btnCancelDialog.setOnClickListener {
                mBuilder.dismiss()
            }
        }

        btnQuit.setOnClickListener {
            val DialogView = layoutInflater.inflate(R.layout.dialog_quit, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(DialogView).setTitle("Image Dialog").show()
            DialogView.btnQuitDialog.setOnClickListener {
                moveTaskToBack(true);
                exitProcess(-1)
            }
            DialogView.btnCancel.setOnClickListener {
                mBuilder.dismiss()
            }
        }

    }
}
