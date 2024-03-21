package com.aarafrao.retrofitmvvm.Repository

import com.aarafrao.retrofitmvvm.Utils.RetrofitObject
import com.example.employee_app.model.EmployeeDataModel

class EmployeeRepo {

    private val apiService = RetrofitObject.apiService


    suspend fun getEmployee(): EmployeeDataModel{
        return apiService.getEmployees()
    }
}