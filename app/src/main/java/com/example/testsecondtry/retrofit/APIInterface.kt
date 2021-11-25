package com.example.testsecondtry.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/search/photos?per_page=30?page=3query=&client_id=YaBHuJMHlBFgIyvbD_H1ZUuXMXiF-iwJaO5e2Rj_p7Y")
    fun getPhotoData(@Query("query")text:String): Call<Photos>

    @GET("/search/photos?per_page=30?page=3query=?color=&client_id=YaBHuJMHlBFgIyvbD_H1ZUuXMXiF-iwJaO5e2Rj_p7Y")
    fun getPhotoDataFilter(@Query("query")text:String,
                           @Query ("color")filter:String): Call<Photos>
}