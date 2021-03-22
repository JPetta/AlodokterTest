package com.example.alodoktertest.Modules.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alodoktertest.R
import com.example.alodoktertest.Modules.Home.View.HomeActivity
import com.example.alodoktertest.util.SharedPrefManager
import com.example.alodoktertest.util.SharedPrefManager.Companion.EMAIL
import com.example.alodoktertest.util.SharedPrefManager.Companion.LOGIN_STATUS
import com.example.alodoktertest.util.SharedPrefManager.Companion.PASSWORD
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var view: View
    lateinit var sharedPref : SharedPrefManager
    lateinit var intentToHome: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        intentToHome = Intent(applicationContext, HomeActivity::class.java)

        sharedPref = SharedPrefManager(applicationContext)
        checkIfLoggedIn()

        btn_login.setOnClickListener {
            if(!et_email.text.isNullOrEmpty() && !et_password.text.isNullOrEmpty()){
                login(et_email.text.toString(), et_password.text.toString())
            } else {
                Toast.makeText(applicationContext, "Please enter email and password", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun checkIfLoggedIn() {
        if (sharedPref.isLoggedIn){
            startActivity(intentToHome)
        }
    }

    private fun login(email: String, password: String) {
        sharedPref.apply{
            saveSPString(EMAIL, email)
            saveSPString(PASSWORD, password)
            saveSPBoolean(LOGIN_STATUS, true)
            startActivity(intentToHome)
        }

    }
}