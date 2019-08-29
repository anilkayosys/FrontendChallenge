package com.kayosys.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kayosys.demo.adapter.CurrencyAdapter
import com.kayosys.demo.model.CurrencyModel
import com.kayosys.demo.presenter.CurrencyListPresenter
import com.kayosys.demo.view.ICurrencyListView
import kotlinx.android.synthetic.main.currency_list.*

class CurrencyList: AppCompatActivity() ,CurrencyAdapter.OnItemClickListener,ICurrencyListView{


    override fun onItemClick(currencyName: String, price: String) {
        val intent= Intent(this,CurrencyConvert::class.java)
        intent.putExtra("currencyName",currencyName)
        intent.putExtra("price",price)
        startActivity(intent)
    }

    lateinit var currencyAdapter: CurrencyAdapter
    val currencyName: ArrayList<String> = ArrayList()
    val price: ArrayList<String> = ArrayList()
    lateinit var currencyListPresenter: CurrencyListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currency_list)
        currencyListPresenter=CurrencyListPresenter(this)
        currency_list_recy.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        currencyListPresenter.onCurrencyList()
    }



    override fun currencyListResult(currencyModel: CurrencyModel) {
        currencyModel.rates?.let {
            for (values in it){
                currencyName.add(values.key.toString())
                price.add(values.value.toString())
                currencyAdapter= CurrencyAdapter(this@CurrencyList,currencyName,price,this@CurrencyList)
                currency_list_recy.adapter=currencyAdapter
            }
        }
    }
}