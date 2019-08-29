package com.kayosys.demo.presenter

import com.kayosys.demo.utils.AppConstants
import com.kayosys.demo.model.CurrencyModel
import com.kayosys.demo.view.ICurrencyListView
import com.kayosys.insurance.businesslogic.apimanager.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyListPresenter(val iCurrencyListView: ICurrencyListView) : ICurrencyListPresenter {

    override fun onCurrencyList() {
        apiCall()
    }


    fun apiCall() {
        val currencyList: Call<CurrencyModel> = retrofitService.getCurrencyData(AppConstants.AccessKey, 1)
        currencyList.enqueue(object : Callback<CurrencyModel> {
            override fun onFailure(call: Call<CurrencyModel>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<CurrencyModel>, response: Response<CurrencyModel>) {
                response.body()?.let {
                    iCurrencyListView.currencyListResult(it)
                }

            }

        })
    }
}