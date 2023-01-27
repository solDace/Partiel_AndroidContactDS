package fr.isen.sorroche.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.sorroche.androidcontactds.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}