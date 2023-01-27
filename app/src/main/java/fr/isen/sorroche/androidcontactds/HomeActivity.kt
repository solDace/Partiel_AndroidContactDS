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
        binding.recyclerViewContact.adapter = HomeAdapter(arrayListOf())
        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI() {

        val url = "https://randomuser.me/api/?results=10&nat=fr"
        val jsonObject = JSONObject()
        jsonObject.put("results", "10")
        val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject, {
            Log.w("HomeActivity","reussite : $it")
            handleAPIData(it.toString())
        }, Response.ErrorListener {
            Log.e("CategoryActivity", "erreur : $it")
        })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String){
        var contactResult = Gson().fromJson(data, Results::class.java)
        val contactCategory= listOf(contactResult)

        val adapter = binding.recyclerViewContact.adapter as HomeAdapter
        adapter.refreshList(contactCategory)
    }
}