package android.linksake.luisangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HTTPget : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_httpget)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query: String) {
        doAsync {
            val call = getRetrofit().create(APIService::class.java).getCharacterByName("$query/images").execute()
            val puppies = call.body() as DogsResponse
            uiThread {
                if(puppies.status == "success") {
                    //initCharacter(puppies)
                }else{
                    //showErrorDialog()
                }
                //hideKeyboard()
            }
        }
    }

}
