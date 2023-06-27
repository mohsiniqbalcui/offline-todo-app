package com.familyaura.todo.retrofit

data class ErrorResponse(
    val error_description: String, // this is the translated error shown to the user directly from the API
    val message: String, // this is the translated error shown to the user directly from the API
    val causes: Map<String, String> = emptyMap() //this is for errors on specific field on a form
)