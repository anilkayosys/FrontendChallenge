package com.kayosys.demo.view

import com.kayosys.demo.model.CurrencyModel

interface ICurrencyListView {
    fun currencyListResult(currencyModel: CurrencyModel)
}