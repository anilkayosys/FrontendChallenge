package com.kayosys.demo.presenter

import com.kayosys.demo.view.ICurrencyConvertView

class CurrencyConvertPresenter(val iCurrencyConvertView: ICurrencyConvertView):
        ICurrencyConvertPresenter {


    var currencyRate:Float= 0.0F
    override fun currencyRate(a: Float) {
        currencyRate=a;
    }
    override fun convertBaseCurrency(a: String) {
        if(a.isEmpty()){
            iCurrencyConvertView.onUpdateBaseCurrency(0F)
        }else{
            iCurrencyConvertView.onUpdateBaseCurrency(a.toFloat()*currencyRate)
        }

    }

    override fun convertSelectedCurrency(a: String) {
        if(a.isEmpty()){
            iCurrencyConvertView.onUpdateSelectedCurrency(0F)
        }else{
            iCurrencyConvertView.onUpdateSelectedCurrency(a.toFloat()*currencyRate)
        }

    }


}