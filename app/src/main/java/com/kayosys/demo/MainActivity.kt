package com.kayosys.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        anagrams_check.setOnClickListener(this)
        fibonacci_number.setOnClickListener(this)
        currency_converter.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.anagrams_check -> {
                val intent = Intent(this, Anagrams::class.java)
                startActivity(intent)
            }
            R.id.fibonacci_number -> {
                val intent = Intent(this, FibonacciNumber::class.java)
                startActivity(intent)
            }
            R.id.currency_converter -> {
                val intent = Intent(this, CurrencyList::class.java)
                startActivity(intent)
            }
        }
    }


}
