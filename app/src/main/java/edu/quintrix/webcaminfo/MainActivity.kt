package edu.quintrix.webcaminfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import edu.quintrix.webcaminfo.api.WebcamItem
import edu.quintrix.webcaminfo.api.WindyFetcher
import edu.quintrix.webcaminfo.api.WindyHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textViewResults) as TextView

        val button = findViewById<Button>(R.id.buttonSubmit) as Button

        val windyLiveData: LiveData<List<WebcamItem>> = WindyFetcher().fetchContents()
        windyLiveData.observe(
            this,
            Observer { webcamItems ->
                Log.d("WindyResponseInMainActivity", "Response received: $webcamItems")

                val str = WindyHelper.getResults(webcamItems)

                textView.text = str
        })


        button.setOnClickListener {
            // this will cause the app to get NEWER data
            windyLiveData.observe(
                this, Observer {
                    webcamItems -> val str = WindyHelper.getResults(webcamItems)

                    textView.text = str
                }
            )
            // it does not appear as though this has any real effect
            // but personally I am thankful that it does not crash!

        }



    }
}
