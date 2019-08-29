package com.kayosys.demo.presenter

import com.kayosys.demo.model.FibonacciNumberModel
import com.kayosys.demo.view.IFibonacciNumberView

class FibonacciNumberPresenter(val iFibonacciNumberView: IFibonacciNumberView) : IFibonacciNumberPresenter {
lateinit var fibonacciNumberModel:FibonacciNumberModel

    override fun onRecursiveApproach(a: Int) {
         fibonacciNumberModel=FibonacciNumberModel(a)
        for (value in 0..a) {
            fibonacciNumberModel.addItem(fibWithRecursive(value))
        }
        iFibonacciNumberView.onShowRecursiveResult(fibonacciNumberModel.array)
    }


    override fun onIterativeApproach(a: Int) {
        fibonacciNumberModel=FibonacciNumberModel(a)
        for (value in 0..a) {
            fibonacciNumberModel.addItem(fibWithIterative(value))
        }
        iFibonacciNumberView.onShowIterativeResult(fibonacciNumberModel.array)
    }

    fun fibWithRecursive(n: Int): Int {
        return if (n <= 1) {
            n
        } else {
            fibWithRecursive(n - 1) + fibWithRecursive(n - 2)
        }
    }


    fun fibWithIterative(n: Int): Int {
        /* Declare an array to store Fibonacci numbers. */
        val f = IntArray(n + 2) // 1 extra to handle case, n = 0
        var i: Int

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0
        f[1] = 1

        i = 2
        while (i <= n) {
            /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i - 1] + f[i - 2]
            i++
        }

        return f[n]
    }
}