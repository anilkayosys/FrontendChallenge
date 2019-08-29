package com.kayosys.demo.presenter

import com.kayosys.demo.model.AnagramModel
import com.kayosys.demo.view.IAnagramView
import java.util.*

class AnagramsPresenter(val iAnagramView: IAnagramView) : IAnagramsPresenter {
    lateinit var  anagramModel: AnagramModel
    override fun areAnagram(str1: CharArray, str2: CharArray) {
        anagramModel=AnagramModel(str1,str2)
        iAnagramView.isAnagram(isAnagram())
    }


    /* function to check whether two strings are
        anagram of each other */
    private fun isAnagram(): Boolean {
        // If length of both strings is not same,
        // then they cannot be anagram
        if (anagramModel.str1.size != anagramModel.str2.size)
            return false

        // Sort both strings
        Arrays.sort(anagramModel.str1)
        Arrays.sort(anagramModel.str2)

        // Compare sorted strings
        for (i in 0 until anagramModel.str1.size)
            if (anagramModel.str1[i] != anagramModel.str2[i])
                return false

        return true
    }
}