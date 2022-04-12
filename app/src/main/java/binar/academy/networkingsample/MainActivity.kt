package binar.academy.networkingsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import binar.academy.networkingsample.model.GetAllCarResponseItem
import binar.academy.networkingsample.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ApiClient.retrofitService.allCar().enqueue(object : Callback<List<GetAllCarResponseItem>>{
//            override fun onResponse(
//                call: Call<List<GetAllCarResponseItem>>,
//                response: Response<List<GetAllCarResponseItem>>
//            ) {
//                Log.d("tag",response.toString())
//            }
//
//            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
//                Log.d("tag",call.toString())
//            }
//
//        })
    }
}