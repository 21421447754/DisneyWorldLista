package martinez.miguel.disneyworldlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import martinez.miguel.disneyworldlista.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: disneyAdapter
    private val DisneyImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycleView()

    }

    private fun initRecycleView() {
        adapter = disneyAdapter(DisneyImages)
        binding.rvDisney.layoutManager= LinearLayoutManager(this)
        binding.rvDisney.adapter = adapter

    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/characters/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun SearchByName(query:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIservice::class.java).getdisneyforlist("$query/ ")
            val disney = call.body()
            runOnUiThread {
              if (call.isSuccessful){
                  val images = disney
              }else{
                  showError()
              }
            }
            if (call.isSuccessful){
                //mostrar
                else{
                //error
                }

            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "algo salio mal :(", Toast.LENGTH_SHORT).show()
    }
}
