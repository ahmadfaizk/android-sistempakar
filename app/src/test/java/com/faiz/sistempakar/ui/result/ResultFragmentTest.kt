package com.faiz.sistempakar.ui.result

import com.faiz.sistempakar.helpers.DataHelper
import com.faiz.sistempakar.model.Infection
import com.faiz.sistempakar.model.Question
import com.faiz.sistempakar.model.Result
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ResultFragmentTest {

    private lateinit var listQuestion: ArrayList<Question>
    private lateinit var listInfection: ArrayList<Infection>

    @Before
    fun init() {
        listQuestion = DataHelper.getListQuestion()
        listInfection = DataHelper.getListInfection()
    }

    @Test
    fun calculate() {
        val listResult = ArrayList<Result>()
        val listIndex = listOf(4)
        for (index in listIndex) {
            listQuestion[index].checked = true
        }
        for (infection in listInfection) {
            val percentage = 100.0f/infection.diseases.size
            var sumPercentage = 0f
            for (disease in infection.diseases) {
                var sum = 0f
                for (index in disease.questions) {
                    if (listQuestion[index-1].checked) {
                        sum++
                    }
                }
                sumPercentage += (sum/disease.questions.size)*percentage
            }
            listResult.add(Result(infection.text, sumPercentage))
        }
        assertNotNull(listResult)
        println(listResult.toString())
    }
}