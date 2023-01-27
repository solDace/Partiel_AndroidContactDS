package fr.isen.sorroche.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.sorroche.androidcontactds.databinding.ActivityDetailBinding
import fr.isen.sorroche.androidcontactds.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}