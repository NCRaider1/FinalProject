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
    var search= ""
    var page = "1"
    var size = "10"
    var genre = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle == null){
            Log.e("MainResult", "MainResult did not receive id")
            return
        }
        search = MainArgs.fromBundle(bundle).message
//        genre = MainArgs.fromBundle(bundle).selectedOption
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_main,container, false)
        val button = view.findViewById<Button>(R.id.favButton)
        //val button2 = view.findViewById<Button>(R.id.sButton)

        button.setOnClickListener{
            view.findNavController().navigate(R.id.action_main_to_favoritesFragment)
        }
//        button2.setOnClickListener {
//            view.findNavController().navigate(R.id.action_main_to_detailsFragment)
//        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(requireContext(), Navigation.findNavController(view))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recyclerAdapter


        val apiInterface = apiInterface.create().getAnime(page, size, search)

        //apiInterface.enqueue( Callback<List<Movie>>())
        if (apiInterface != null) {
            apiInterface.enqueue(object : Callback<ArrayList<Data?>?>{
                override fun onResponse(
                    call: Call<ArrayList<Data?>?>, response: Response<ArrayList<Data?>?>) {
//                    if (response != null) {
//                        Log.d("Main activity", response.body().toString())
//                    }
//                    var animeItem: AnimeItem? = response.body()
                    if (response?.body() != null)
                        recyclerAdapter.setAnimeListItems(response.body()!! as ArrayList<Data>)
                    Log.d("Main activity", response.body().toString())
                }

                override fun onFailure(call:Call<ArrayList<Data?>?>, t: Throwable) {
                 //   if (t != null) {
//                        Toast.makeText(requireContext(), t.message,
//                            Toast.LENGTH_SHORT).show()
                        t.message?.let { Log.d("onFailure", it) }
                //    }
                }
            })
        }

    }

}

private fun <T> Call<T>.enqueue(callback: Callback<ArrayList<Data?>?>) {

}

