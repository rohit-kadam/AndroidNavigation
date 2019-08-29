package com.androidnavigation


import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        Handler().postDelayed({
            val sharedPref = SharedPref(activity as Context, Constants.SHARED_PREF_USER_OBJECT)
            val username = sharedPref.getString(Constants.SHARED_PREF_USERNAME, "")
            if (username == "") {
                findNavController().navigate(
                    R.id.action_splashFragment_to_loginFragment3,
                    null,
                    NavOptions.Builder().setPopUpTo(R.id.splashFragment,true).build())
            } else {
                username?.let {
                    findNavController().navigate(
                        SplashFragmentDirections.actionSplashFragmentToHomeFragment(it),
                        NavOptions.Builder().setPopUpTo(R.id.splashFragment,true).build())
                }
            }
        }, 2000)
    }

}
