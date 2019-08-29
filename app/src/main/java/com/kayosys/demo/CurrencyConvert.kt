package com.kayosys.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.kayosys.demo.presenter.CurrencyConvertPresenter
import com.kayosys.demo.view.ICurrencyConvertView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.currency_convert.*
import java.math.BigDecimal

class CurrencyConvert: AppCompatActivity() ,ICurrencyConvertView{



    var price:Float= 0.0F;
    lateinit var currencyName:String
    lateinit var baseCurrencyEd:EditText
    lateinit var selectedCurrencyEd:EditText

    lateinit var currencyConvertPresenter: CurrencyConvertPresenter

    val baseChangedListener = BaseChangedListener()
    val selecedChangedListener = SelectedChangedListener()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currency_convert)
        baseCurrencyEd=findViewById(R.id.baseCurrencyEd)
        selectedCurrencyEd=findViewById(R.id.selectedCurrencyEd)
        price=intent.getStringExtra("price").toFloat()
        currencyName=intent.getStringExtra("currencyName")

        currencyConvertPresenter= CurrencyConvertPresenter(this)
        currencyConvertPresenter.currencyRate(price)

        baseCurrency.setText("EUR")
        selectedCurrency.setText(currencyName)
        selectedCurrencyEd.addTextChangedListener(selecedChangedListener)
        baseCurrencyEd.addTextChangedListener(baseChangedListener)
        baseCurrencyEd.setText("1")
    }


    inner class BaseChangedListener : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            currencyConvertPresenter.convertSelectedCurrency(s.toString())
        }
        override fun afterTextChanged(s: Editable) {}
    }


    inner class SelectedChangedListener : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            currencyConvertPresenter.convertBaseCurrency(s.toString())
        }
        override fun afterTextChanged(s: Editable) {}
    }


    override fun onUpdateBaseCurrency(a: Float) {
        baseCurrencyEd.removeTextChangedListener(baseChangedListener)
        baseCurrencyEd.setText(a.toString())
        baseCurrencyEd.addTextChangedListener(baseChangedListener)
    }

    override fun onUpdateSelectedCurrency(a: Float) {
        selectedCurrencyEd.removeTextChangedListener(selecedChangedListener)
        selectedCurrencyEd.setText(a.toString())
        selectedCurrencyEd.addTextChangedListener(selecedChangedListener)
    }

}