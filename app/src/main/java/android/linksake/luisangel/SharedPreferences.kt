package android.linksake.luisangel

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val name = sharedPreferences.getString("name", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val email = sharedPreferences.getString("email", "")

        this.etNameSP.setText(name)
        this.etLastNameSP.setText(lastName)
        this.etEmailSP.setText(email)

        btnCancelSP.setOnClickListener {
            editor.clear()
            editor.commit()
        }

        btnSaveSP.setOnClickListener {
            editor.putString("name", etNameSP.text.toString())
            editor.putString("lastName", etLastNameSP.text.toString())
            editor.putString("email", etEmailSP.text.toString())
            editor.commit()
        }


    }
}
