package edu.quintrix.webcaminfo.api

import com.google.gson.annotations.SerializedName

class WebcamResponse {
    @SerializedName("webcams")
    lateinit var  webcamItems : List<WebcamItem>
}