package edu.quintrix.webcaminfo.api

import retrofit2.Call
import retrofit2.http.GET
import edu.quintrix.webcaminfo.api.*

interface WindyApi {

    //THE KEY PARAMETER IS OMITTED IF YOU ARE VIEWING THIS ON GITHUB!
    //THIS IS FOR MY SECURITY AND FOR THE SECURITY OF THE API PROVIDER!
    @GET("list/? &key=YOUR_KEY_HERE")
    fun fetchContents(): Call<WindyResponse>

}