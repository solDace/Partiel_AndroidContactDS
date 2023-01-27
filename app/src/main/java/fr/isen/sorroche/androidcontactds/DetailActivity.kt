package fr.isen.sorroche.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import fr.isen.sorroche.androidcontactds.databinding.ActivityDetailBinding
import fr.isen.sorroche.androidcontactds.databinding.ActivityMainBinding
import fr.isen.sorroche.androidcontactds.model.Contact
import fr.isen.sorroche.androidcontactds.model.Results

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstImage =intent.getSerializableExtra("photo").toString()
        Picasso.get().load(firstImage).resize(50, 50).into(binding.imageDetail)
        binding.nomDetail.text = intent.getSerializableExtra("nom").toString()
        binding.adressDetail.text = intent.getSerializableExtra("adresse").toString()
        binding.mailDetail.text = intent.getSerializableExtra("mail").toString()
        binding.phoneDetail.text = intent.getSerializableExtra("num").toString()
        binding.annivDetail.text = intent.getSerializableExtra("date").toString()

    }
}