package com.aarafrao.retrofitmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarafrao.retrofitmvvm.Repository.EmployeeRepo
import com.example.employee_app.model.EmployeeDataModel
import kotlinx.coroutines.launch

class EmployeeVM : ViewModel() {

    private val repo = EmployeeRepo()
    private val _emp = MutableLiveData<EmployeeDataModel>()


    val emp: LiveData<EmployeeDataModel>
        get() = _emp


    fun loadEMP(){
        viewModelScope.launch {
            val result = repo.getEmployee()
            _emp.postValue(result)
        }
    }


}