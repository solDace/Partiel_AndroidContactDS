package fr.isen.sorroche.androidcontactds

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.sorroche.androidcontactds.model.Contact
import fr.isen.sorroche.androidcontactds.model.Results

class HomeAdapter (var dataSet: List<Results>): RecyclerView.Adapter<HomeAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.nom_contact)
        val address: TextView = view.findViewById(R.id.addresse_contact)
        val mail: TextView = view.findViewById(R.id.mail_contact)
        val image : ImageView = view.findViewById(R.id.image_contact)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nom.text = dataSet[position].name.toString()
        viewHolder.address.text = dataSet[position].location.toString()
        viewHolder.mail.text = dataSet[position].email

        val firstImage = dataSet[position].picture


    }

    fun refreshList(contactFromAPI: List<Results>){
        dataSet =contactFromAPI
        Log.w("data",dataSet.toString())
        notifyDataSetChanged()
    }

}