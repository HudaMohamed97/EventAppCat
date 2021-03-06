package com.example.myapplication.LoginFragment

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catapplication.utilies.Validation
import com.example.myapplication.Models.ResponseModelData


class LoginViewModel : ViewModel() {
    private var repositoryHelper: LoginRepository = LoginRepository()
    private lateinit var mutableLiveData: MutableLiveData<ResponseModelData>
    private lateinit var shared: SharedPreferences
    val isLoading = MutableLiveData<Boolean>()


    fun validateLoginInfo(
        emailEt: String,
        passwordEt: String
    ): Boolean {
        val isEmailValid = Validation.validateEmail(emailEt)
        val isPasswordValid = Validation.validate(passwordEt)
        return !(!isEmailValid || !isPasswordValid)
    }


    fun login(emailEt: String, passwordEt: String, type: Int) {
        // isLoading.value = true
        mutableLiveData = repositoryHelper.login(emailEt, passwordEt, type)

    }

    /*fun saveData(userData: Data, context: Context) {
        shared = context.getSharedPreferences("id", Context.MODE_PRIVATE)
        val myDataHolder = shared.edit()
        *//*myDataHolder.putInt("id", userData.id)
        Log.i("hhhh", "" + userData.id)
        myDataHolder.putString("name", userData.username)
        myDataHolder.putString("email", userData.email)
        myDataHolder.putString("account_type", userData.account_type)
        myDataHolder.putInt("target", userData.target)
        myDataHolder.putInt("score", userData.score)
        myDataHolder.putInt("percentage", userData.percentage)
        myDataHolder.putString("username", userData.username)*//*
        myDataHolder.apply()
    }*/

    fun getData(): MutableLiveData<ResponseModelData> {
        return mutableLiveData


    }


}







