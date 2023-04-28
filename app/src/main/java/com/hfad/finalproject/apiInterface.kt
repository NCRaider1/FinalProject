package com.hfad.finalproject

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface apiInterface
{

    //base URL for the REST API

    @GET("/anime?")
    @Headers("X-RapidAPI-Key:f158130070msh6012532894e45bbp111b33jsn2c64a81e9a33", "X-RapidAPI-Host:anime-db.p.rapidapi.com")
    fun getAnime(@Query("search") search:String, @Query("genres") genres:String, @Query("page") page:Int, @Query("size") size:Int, @Query("sortOrder") sortOrder:String): Call<ArrayList<AnimeItems?>?>?
    companion object{

        var BASE_URL = "http://anime-dp.p.rapidapi.com"

        fun create() : apiInterface
        {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .build()

            return retrofit.create(apiInterface::class.java)
        }
    }
}