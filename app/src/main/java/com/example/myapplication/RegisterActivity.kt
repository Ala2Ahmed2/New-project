package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.example.myapplication.view.MainActivity

@SuppressLint("checkResult")
class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener{

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.etFullName.onFocusChangeListener = this
        binding.etEmail2.onFocusChangeListener = this
        binding.etPassword2.onFocusChangeListener = this

        //Click
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.tvHaveAccount.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }



    private fun validateFullName(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.etFullName.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Full Name is required"
        }
        return errorMassage == null
    }


    private fun validateEmail(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.etEmail2.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Email is required"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            errorMassage = "Email address is invalid"
        }
        return errorMassage == null
    }

    private fun validatePassword(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.etPassword2.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Password is required"
        } else if (value.length < 6) {
            errorMassage = "Password must be 6 characters long"
        }
        return errorMassage == null
    }

    private fun validateName(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.etUserName.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Name is required"
        }
        return errorMassage == null
    }

    private fun validatePhone(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.phone.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Phone is required"
        } else if (!Patterns.PHONE.matcher(value).matches()) {
            errorMassage = "Phone number is invalid"
        }
        return errorMassage == null
    }

    private fun validateDate(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.date.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Birth date is invalid"
        }
        return errorMassage == null
    }

    private fun validateGender(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.gender.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Gender is required"
        }
        return errorMassage == null
    }

    private fun validateNationality(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.nationality.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "nationality is required"
        }
        return errorMassage == null
    }

    private fun validateResidence(): Boolean {
        var errorMassage: String? = null
        val value: String = binding.residence.editText.toString()
        if (value.isEmpty()) {
            errorMassage = "Place of residence is required"
        }
        return errorMassage == null
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null){
            when(view.id){
                R.id.et_fullName -> {
                    if (hasFocus){
                        if (binding.etFullName.isCounterEnabled)
                            binding.etFullName.isErrorEnabled = false
                    }else{
                       validateFullName()
                    }
                }
                R.id.et_email -> {
                    if (hasFocus){
                        if (binding.etEmail2.isCounterEnabled)
                            binding.etEmail2.isErrorEnabled = false
                    }else{
                       if (validateEmail()){

                       }
                    }
                }
                R.id.et_password -> {
                    if (hasFocus){
                        if (binding.etPassword2.isCounterEnabled)
                            binding.etPassword2.isErrorEnabled = false
                    }else{
                        validatePassword()
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}