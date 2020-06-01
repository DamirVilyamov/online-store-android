package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var imageNames: ArrayList<String> = ArrayList()
    private var imageUrls: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: started")
        initImageBitmaps()
        initRecyclerView()
    }

    private fun initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps")

        imageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        imageNames.add("Trondheim");

        imageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        imageNames.add("Portugal");

        imageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        imageNames.add("Rocky Mountain National Park");


        imageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        imageNames.add("Mahahual");

        imageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        imageNames.add("Frozen Lake");


        imageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        imageNames.add("White Sands Desert");

        imageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        imageNames.add("Austrailia");

        imageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        imageNames.add("Washington");
    }
    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(imageNames, imageUrls)
        }

    }

}