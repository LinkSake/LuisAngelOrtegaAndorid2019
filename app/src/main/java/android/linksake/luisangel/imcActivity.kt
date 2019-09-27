package android.linksake.luisangel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_imc.*
import kotlinx.android.synthetic.main.activity_main.*
import me.dm7.barcodescanner.zxing.ZXingScannerView


abstract class imcActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)




        btnScan.setOnClickListener({

        })

        btnGetIMC.setOnClickListener({
            checkForEmpty()
            calcularMasaCorporal()
        })

    }

    private fun calcularMasaCorporal() {

        var status = R.string.IMCstatus
        var pesoEnKg = etWeight.text.toString().toDouble()
        var estaturaEnMetros = etHeight.toString().toDouble()

        var imc = pesoEnKg / (estaturaEnMetros * estaturaEnMetros)

        var estatusDelPaciente: String

        when(imc) {
            in 19.0..24.9 -> estatusDelPaciente = "El paciente se encuentra en el peso adecuado"
            else ->  estatusDelPaciente = "El paciente NO se encuentra en el peso adecuado"
        }

        tvIMCstatus.text = "${status}${estatusDelPaciente}"

    }

    private fun checkForEmpty() {
        if( etHeight.text.isEmpty() || etWeight.text.isEmpty()){
            Toast.makeText(this, R.string.allRequired, Toast.LENGTH_SHORT).show()
        }
    }



}
