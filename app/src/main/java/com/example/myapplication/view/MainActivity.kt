package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.model.UserData
import com.example.myapplication.R
import com.example.myapplication.utils.APIConsumer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://al3rabia.com/home/Login/AndroidLogin"
class MainActivity : AppCompatActivity() {

    private lateinit var et_email: EditText
    private lateinit var et_password: EditText
    private lateinit var tv_forget_pass: TextView
    private lateinit var tv_create_account: TextView
    private lateinit var btn_login: Button

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData()

        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        tv_forget_pass = findViewById(R.id.tv_forget_pass)
        tv_create_account = findViewById(R.id.tv_create_account)
        btn_login = findViewById(R.id.btn_login)

        btn_login.setOnClickListener{

            val email = et_email.text.toString().trim()
            val password = et_password.text.toString().trim()

            if (email.isEmpty()){
                et_email.error = "Email is required"
                return@setOnClickListener
            }else if (password.isEmpty()){
                et_password.error = "Email is required"
                return@setOnClickListener
            }else{
                Toast.makeText(this, "Validation Completed", Toast.LENGTH_SHORT).show()
            }
        }

    }

    //Retrofit Builder
    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val ApiInterface = retrofitBuilder.create(APIConsumer::class.java)

        val userData = UserData()

        val call = ApiInterface.sendUserData(userData)

        call.enqueue(object: Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                response.code().toString()
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                Log.d("Failed retrofit",t.message.toString())


            }
        })



        }
    }