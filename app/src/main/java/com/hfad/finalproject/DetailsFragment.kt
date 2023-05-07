//package com.hfad.finalproject
//
//import android.os.Bundle
//import android.util.Log
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.navigation.findNavController
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//import com.hfad.finalproject.databinding.ActivityMainBinding
//import com.hfad.finalproject.databinding.FragmentDetailsBinding
//import com.hfad.finalproject.DetailsFragmentArgs
//
//
//class DetailsFragment : Fragment() {
//
//    var anime_id: Int = 0
//
//    private var _binding: FragmentDetailsBinding? = null
//    // This property is only valid between onCreateView and
//// onDestroyView.
//    private val binding get() = _binding!!
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val bundle = arguments
//        if (bundle == null) {
//            Log.e("DetailsFragment", "DetailsFragment did not receive hero id")
//
//            return
//        }
//        anime_id = DetailsFragmentArgs.fromBundle(bundle).animeId
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
//        val view = binding.root
//        //val view = inflater.inflate(R.layout.fragment_results, container, false)
//        val button = view.findViewById<Button>(R.id.favButton)
//        val button2 = view.findViewById<Button>(R.id.sButton)
//
//        button.setOnClickListener{
//            view.findNavController().navigate(R.id.action_detailsFragment_to_favoritesFragment)
//        }
//        button2.setOnClickListener {
//            view.findNavController().navigate(R.id.action_detailsFragment_to_searchFragment)
//        }
//        return view
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.title.text = animeList.get(anime_id).title
//        binding.genres.text = animeList.get(anime_id).genres
//        //binding.ranking.text = animeList.get(anime_id).ranking
//        binding.status.text = animeList.get(anime_id).status
//        //binding.episode.text= animeList.get(anime_id).episode
//        binding.synopsis.text = animeList.get(anime_id).synopsis
//        Glide.with(requireContext()).load(animeList.get(anime_id).image)
//            .apply(RequestOptions().centerCrop())
//            .into(binding.itemImage)
//
//    }
//
//}