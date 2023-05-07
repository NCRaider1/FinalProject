package com.hfad.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.navigation.findNavController
import com.hfad.finalproject.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    var selectedOption: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        val button = binding.confirmButton
        val button2 = binding.favButton
        val spinner = binding.spinner

        setupSpinner(spinner) { option -> selectedOption = option }


        button.setOnClickListener{
            val navController = view.findNavController()
            val message = binding.searchText.text.toString()
            val selection = selectedOption.toString()
           val apiInterface = apiInterface.create().getAnime("1", "10", message)
            val action = SearchFragmentDirections.actionSearchFragmentToMain(message)
            navController.navigate(action)
        }
        button2.setOnClickListener{
            view.findNavController().navigate(R.id.action_searchFragment_to_favoritesFragment)
        }


        return view
    }

    private fun setupSpinner(spinner: Spinner, onItemSelected: (option: String?) -> Unit) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val option = parent?.getItemAtPosition(position).toString()
                onItemSelected(option)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

}