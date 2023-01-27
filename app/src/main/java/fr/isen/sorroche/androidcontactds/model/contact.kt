package fr.isen.sorroche.androidcontactds.model

import com.google.gson.annotations.SerializedName


data class contact (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("info"    ) var info    : Info?              = Info()

)