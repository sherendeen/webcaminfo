package edu.quintrix.webcaminfo.api

import android.util.Log

class WindyHelper {
    companion object {
        fun getResults (list : List<WebcamItem>) : String {

            var str : String = ""
            for (x  in list ) {
                Log.d("WINDYHELPER","${x.id} ${x.title}\n")
                str += "${x.id} ${x.title}\n"
            }

            return str
        }
    }
}