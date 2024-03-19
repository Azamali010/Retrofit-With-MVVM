package com.example.employee_app.model


import com.google.gson.annotations.SerializedName

data class EmployeeDataModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String
)