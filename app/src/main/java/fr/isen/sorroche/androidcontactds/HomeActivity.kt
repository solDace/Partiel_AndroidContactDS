package fr.isen.sorroche.androidcontactds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.sorroche.androidcontactds.databinding.ActivityMainBinding
import fr.isen.sorroche.androidcontactds.model.Contact
import fr.isen.sorroche.androidcontactds.model.Results
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.recyclerViewContact.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewContact.adapter = HomeAdapter(arrayListOf()){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("photo", it.picture?.large)
            intent.putExtra("nom", it.name?.first+" "+it.name?.last)
            intent.putExtra("adresse", it.location?.street?.number.toString()+" "+it.location?.street?.name+" "+it.location?.city+" "+
                    it.location?.postcode +" "+it.location?.country)
            intent.putExtra("mail", it.email)
            intent.putExtra("num", it.phone)
            intent.putExtra("date", it.dob?.date)
            startActivity(intent)
        }
        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI() {

        val url = "https://randomuser.me/api/?results=10&nat=fr"
        val jsonObject = JSONObject()
        val jsonRequest = JsonObjectRequest(Request.Method.GET, url, jsonObject, {
            Log.w("HomeActivity","reussite : $it")
            handleAPIData(it.toString())
        }, Response.ErrorListener {
            Log.e("HomeActivity", "erreur : $it")
        })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String){
        var contactResult = Gson().fromJson(data, Contact::class.java)
        val contactCategory= contactResult.results

        val adapter = binding.recyclerViewContact.adapter as HomeAdapter
        adapter.refreshList(contactCategory)
    }
}