package com.kayosys.demo.model

data class FibonacciNumberModel(val n:Int) {

    var array= ArrayList<Int>()
    fun addItem(a:Int){
        array.add(a)
    }
}