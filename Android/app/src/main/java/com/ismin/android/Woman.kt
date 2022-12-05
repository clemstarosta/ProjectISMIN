package com.ismin.android

import com.google.gson.annotations.SerializedName

data class Woman(val name: String, val desc1: String,
                 val desc2: String, val desc3: String, val desc4: String,
                 val desc5: String, val place: String,
                 val category: String, val long: Number,
                 val lat: Number, val thumb_url: String,
                 @SerializedName("fav")
                 var fav: Boolean): java.io.Serializable
