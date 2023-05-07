package com.hfad.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_splash, container, false)

        val button : Button = view.findViewById(R.id.eButton)
        button.setOnClickListener{
            view.findNavController().navigate(R.id.action_splashFragment_to_searchFragment)
        }

        return view
    }

//    fun goToMainActivity() {
//        val intent = Intent(activity, MainActivity::class.java)
//        startActivity(intent)
//    }
}