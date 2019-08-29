package com.kayosys.insurance.businesslogic.apimanager


import com.kayosys.demo.model.CurrencyModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    @GET("latest")
    fun getCurrencyData(@Query("access_key") accessKey:String, @Query("format") format:Int): Call<CurrencyModel>
}