package android.linksake.luisangel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.login_dialog.view.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btnShowDialog.setOnClickListener {

            val myDialogView = layoutInflater.inflate(R.layout.login_dialog, null)

            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("Login Form").show()


            myDialogView.btnDialogLogin.setOnClickListener {

                val name = myDialogView.txtName.text.toString()
                val password = myDialogView.txtPassword.text.toString()
                val email = myDialogView.txtEmail.text.toString()

                tvDialogResult.setText("Nombre: ${name}\n Email: ${email}\n Password:${password}")

                mBuilder.dismiss()

            }

            myDialogView.btnDialogCancel.setOnClickListener {

                mBuilder.dismiss()

            }


        }

    }
}
