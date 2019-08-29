package com.kayosys.demo.presenter

interface ICurrencyConvertPresenter {
    fun currencyRate(a:Float)
    fun convertBaseCurrency(a:String)
    fun convertSelectedCurrency(a:String)
}