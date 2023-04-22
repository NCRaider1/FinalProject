package com.hfad.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class Main : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val button = view.findViewById<Button>(R.id.favButton)
        val button2 = view.findViewById<Button>(R.id.sButton)

        button.setOnClickListener{
            view.findNavController().navigate(R.id.action_main_to_favoritesFragment)
        }
        button2.setOnClickListener {
            view.findNavController().navigate(R.id.action_main_to_searchFragment)
        }
        return view
    }

}