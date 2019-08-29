package com.androidnavigation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener() {
        btn_login.setOnClickListener {
            val username = edt_username.text.toString()
            val password = edt_password.text.toString()
            if (username == "admin" && password == "admin") {
                //store user data
                val sharedPref = SharedPref(activity as Context, Constants.SHARED_PREF_USER_OBJECT)
                sharedPref.putString(Constants.SHARED_PREF_USERNAME, username)
                sharedPref.putString(Constants.SHARED_PREF_PASSWORD, password)
                sharedPref.apply()
                //open home activity
                it.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment2(username),
                    NavOptions.Builder().setPopUpTo(R.id.loginFragment,true).build())
            } else
                Toast.makeText(activity, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }


}
