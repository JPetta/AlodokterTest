package com.example.alodoktertest.Modules.Home.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alodoktertest.Modules.Login.LoginActivity
import com.example.alodoktertest.R
import com.example.alodoktertest.util.SharedPrefManager
import com.example.alodoktertest.util.SharedPrefManager.Companion.LOGIN_STATUS
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {
    lateinit var viewFragment: View
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.fragment_profile, container, false)
        sharedPrefManager = SharedPrefManager(viewFragment.context)
        viewFragment.tv_email.text = sharedPrefManager.email

        viewFragment.btnLogout.setOnClickListener {
            sharedPrefManager.clearAll()
            sharedPrefManager.saveSPBoolean(LOGIN_STATUS, false)
            startActivity(Intent(viewFragment.context, LoginActivity::class.java))
        }
        return viewFragment
    }

    companion object {

    }
}