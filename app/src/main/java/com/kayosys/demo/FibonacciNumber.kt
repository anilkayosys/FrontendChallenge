package com.kayosys.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.kayosys.demo.presenter.FibonacciNumberPresenter
import com.kayosys.demo.view.IFibonacciNumberView
import kotlinx.android.synthetic.main.fibonacci_number.*

class FibonacciNumber : AppCompatActivity(), View.OnClickListener, IFibonacciNumberView {



    lateinit var fibonacciNumberPresenter: FibonacciNumberPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fibonacci_number)
        fibonacciNumberPresenter = FibonacciNumberPresenter(this)
        recursiveNumberBtn.setOnClickListener(this)
        iterativeNumberBtn.setOnClickListener(this)
    }

    override fun onShowRecursiveResult(a: ArrayList<Int>) {
        recursiveNumberResult.text=a.toString()
    }

    override fun onShowIterativeResult(a: ArrayList<Int>) {
        iterativeNumberResult.text=a.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.recursiveNumberBtn -> {
                var recursiveNumber = recursiveNumberEd.text.toString()
                if(recursiveNumber.toInt()<=30){
                    fibonacciNumberPresenter.onRecursiveApproach(recursiveNumber.toInt())
                }else{
                    Toast.makeText(this,"please enter less than 30",Toast.LENGTH_SHORT).show()
                }

            }
            R.id.iterativeNumberBtn -> {
                var iterativeNumber = iterativeNumberEd.text.toString()
                if(iterativeNumber.toInt()<=30){
                    fibonacciNumberPresenter.onIterativeApproach(iterativeNumber.toInt())
                }else{
                    Toast.makeText(this,"please enter less than 30",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}