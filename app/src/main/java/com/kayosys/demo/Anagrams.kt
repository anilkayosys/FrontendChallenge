package com.kayosys.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.kayosys.demo.presenter.AnagramsPresenter
import com.kayosys.demo.view.IAnagramView
import kotlinx.android.synthetic.main.anagram.*
import java.util.*

class Anagrams : AppCompatActivity() ,View.OnClickListener ,IAnagramView{


    lateinit var anagramsPresenter: AnagramsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anagram)
        anagramsPresenter= AnagramsPresenter(this)
        checkAnagram.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.checkAnagram->{
                check();
            }
        }
    }

    private fun check() {
        var firstString=firstStringEd.text.toString()
        var secondtring=secondStringEd.text.toString()
        anagramsPresenter.areAnagram(firstString.toCharArray(),secondtring.toCharArray());

    }

    override fun isAnagram(a: Boolean) {
        if(a){
            resultTV.setText(R.string.anagram_anagram)
        }else{
            resultTV.setText(R.string.anagram_not_anagram)
        }
    }

}