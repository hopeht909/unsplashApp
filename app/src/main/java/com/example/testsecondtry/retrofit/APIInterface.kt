package com.example.testsecondtry.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/search/photos?query=&client_id=YaBHuJMHlBFgIyvbD_H1ZUuXMXiF-iwJaO5e2Rj_p7Y")
    fun getPhotoData(@Query("query")text:String): Call<Photos>
}