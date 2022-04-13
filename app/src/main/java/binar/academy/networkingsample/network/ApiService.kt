package binar.academy.networkingsample.network

import binar.academy.networkingsample.model.GetAllCarResponseItem
import binar.academy.networkingsample.model.RegisterResponseItem
import binar.academy.networkingsample.request.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
        @GET("admin/car")
        fun allCar(): Call<List<GetAllCarResponseItem>>
        @POST("admin/auth/register")
        fun registerAdmin(@Body registerRequest: RegisterRequest):Call<RegisterResponseItem>
}