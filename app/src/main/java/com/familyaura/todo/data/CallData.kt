package com.familyaura.todo.data

import com.google.gson.annotations.SerializedName

data class CallData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("number") var number: String? = null
)
