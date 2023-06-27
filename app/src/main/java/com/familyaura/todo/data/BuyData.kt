package com.familyaura.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ItemToSell")
data class BuyData(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("type") var type: Int? = null
)
