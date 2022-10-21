package com.rifqipadisiliwangi.latihan_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rifqipadisiliwangi.latihan_mvp.model.DataCarItem
import com.rifqipadisiliwangi.latihan_mvp.network.ApiClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {

    var liveCarData: MutableLiveData<List<DataCarItem>> = MutableLiveData()

    fun getData(): MutableLiveData<List<DataCarItem>> {
        return liveCarData
    }

    fun callGet() {
        GlobalScope.async {
            ApiClient.instance.getAllCar()
                .enqueue(object : Callback<List<DataCarItem>> {
                    override fun onResponse(
                        call: Call<List<DataCarItem>>,
                        response: Response<List<DataCarItem>>
                    ) {
                        if (response.isSuccessful) {
                            liveCarData.postValue(response.body())
                        } else {
                            liveCarData.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<List<DataCarItem>>, t: Throwable) {
                        liveCarData.postValue(null)
                    }

                })
        }
    }

}