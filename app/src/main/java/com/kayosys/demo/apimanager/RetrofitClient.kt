package com.kayosys.insurance.businesslogic.apimanager

import com.kayosys.demo.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitService by lazy {
    RetrofitClient.create()
}

class RetrofitClient {
    companion object {
        fun create(): RetrofitInterface {
            val retrofit = Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
            return retrofit.create(RetrofitInterface::class.java)
        }
    }
}