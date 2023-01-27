package fr.isen.sorroche.androidcontactds.model

import com.google.gson.annotations.SerializedName


data class Contact (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("info"    ) var info    : Info?              = Info()

)