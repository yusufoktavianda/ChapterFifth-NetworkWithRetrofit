package binar.academy.networkingsample.network

import binar.academy.networkingsample.model.GetAllCarResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
        @GET("admin/car")
        fun allCar(): Call<List<GetAllCarResponseItem>>
}