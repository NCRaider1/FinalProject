package com.hfad.finalproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.finalproject.databinding.ActivityMainBinding
import com.hfad.finalproject.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    private var _binding: FragmentMainBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    var message= ""
    var page = 1
    var size = 10
    var genre = ""
    var sortOrder = "asc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(requireContext(), Navigation.findNavController(view))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recyclerAdapter


        val apiInterface = apiInterface.create().getAnime(message, genre, page, size, sortOrder)

        //apiInterface.enqueue( Callback<List<Movie>>())
        if (apiInterface != null) {
            apiInterface.enqueue( object : Callback<ArrayList<AnimeItems?>?> {
                override fun onResponse(call: Call<ArrayList<AnimeItems?>?>?, response: Response<ArrayList<AnimeItems?>?>) {
                    if (response != null) {
                        Log.d("Main activity", response.body().toString())
                    }
                    if(response?.body() != null)
                        recyclerAdapter.setHerosListItems(response.body()!! as ArrayList<AnimeItems>)
                }

                override fun onFailure(call: Call<ArrayList<AnimeItems?>?>, t: Throwable) {
                    if (t != null) {
                        Toast.makeText(requireContext(), t.message,
                            Toast.LENGTH_SHORT).show()
                        t.message?.let { Log.d("onFailure", it) }
                    }
                }
            })
        }

    }

}