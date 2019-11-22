package android.linksake.luisangel


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imc.*
import org.json.JSONException
import org.json.JSONObject



class imcActivity : AppCompatActivity() {

    var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        qrScanIntegrator = IntentIntegrator(this)
        qrScanIntegrator?.setOrientationLocked(false)


        btnScanQR!!.setOnClickListener({
            performAction()
            Log.d("OK","1")
        })

        btnGetIMC.setOnClickListener({
            if (!checkForEmpty()){
                calcularMasaCorporal()
            }
        })

    }

    private fun calcularMasaCorporal() {

        var status = R.string.IMCstatus
        var pesoEnKg = etWeight.text.toString().toDouble()
        var estaturaEnMetros = etHeight.text.toString().toDouble()

        var imc = pesoEnKg / (estaturaEnMetros * estaturaEnMetros)

        var estatusDelPaciente: String

        when(imc) {
            in 19.0..24.9 -> estatusDelPaciente = "\nEl paciente se encuentra en el peso adecuado"
            else ->  estatusDelPaciente = "\nEl paciente NO se encuentra en el peso adecuado"
        }

        tvIMCstatus.text = "${status}${estatusDelPaciente}"

    }

    private fun checkForEmpty(): Boolean {
        if( etHeight.text.isEmpty() || etWeight.text.isEmpty()){
            Toast.makeText(this, R.string.allRequired, Toast.LENGTH_SHORT).show()
            return true
        } else {
            return false
        }
    }

    private fun performAction() {
        Log.d("Okay","2")
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this, "JSON vacío", Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    Log.d("JSON", obj.toString())

                    // Show values in UI.
                    etName.setText(obj.getString("name"))
                    etFname.setText(obj.getString("fName"))
                    etMname.setText(obj.getString("mName"))
                    etHeight.setText(obj.getString("height"))
                    etWeight.setText(obj.getString("weight"))
                    Picasso.get().load(obj.getString("picture")).into(ivPicture);


                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }




}
