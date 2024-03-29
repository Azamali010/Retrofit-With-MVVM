package com.aarafrao.retrofitmvvm.Utils

import com.example.employee_app.model.EmployeeDataModel
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/employees")
    suspend fun getEmployees():EmployeeDataModel
}