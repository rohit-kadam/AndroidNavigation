package com.androidnavigation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setListener()
    }

    private fun init() {
        tv_name.text = "Welcome, ${args.username}"
    }

    private fun setListener() {
        btn_logout.setOnClickListener{
            val sharedPref = SharedPref(activity as Context, Constants.SHARED_PREF_USER_OBJECT)
            sharedPref.clear()
            findNavController().navigate(
                R.id.action_homeFragment_to_splashFragment, null, NavOptions.Builder().setPopUpTo(R.id.homeFragment,true).build())
        }
    }

}
