package com.rifqipadisiliwangi.latihan_mvp.network

import retrofit2.Call
import com.rifqipadisiliwangi.latihan_mvp.model.DataCarItem
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar() : Call<List<DataCarItem>>

}