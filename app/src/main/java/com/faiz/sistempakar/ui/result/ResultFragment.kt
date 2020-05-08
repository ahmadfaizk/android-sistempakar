package com.faiz.sistempakar.ui.result

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.faiz.sistempakar.R
import com.faiz.sistempakar.helpers.DataHelper
import com.faiz.sistempakar.model.Question
import com.faiz.sistempakar.model.Result
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    companion object {
        const val EXTRA_QUESTIONS = "extra_questions"
    }

    private lateinit var listQuestions : ArrayList<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listQuestions = arguments?.getParcelableArrayList<Question>(EXTRA_QUESTIONS) as ArrayList<Question>

        tv_result.text = listQuestions.toString()
        calculate()

        btnResult.setOnClickListener {
            it.findNavController().navigate(R.id.action_resultFragment_to_thresholdFragment)
        }
    }

    private fun calculate() {
        val listInfection = DataHelper.getListInfection()
        val listResult = ArrayList<Result>()
        for (infection in listInfection) {
            val percentage = 100.0f/infection.diseases.size
            var sumPercentage = 0f
            for (disease in infection.diseases) {
                var sum = 0f
                for (index in disease.questions) {
                    if (listQuestions[index-1].checked) {
                        sum++
                    }
                }
                sumPercentage += (sum/disease.questions.size)*percentage
            }
            listResult.add(Result(infection.text, sumPercentage))
        }
        tv_result.text = "${tv_result.text} \n ${listResult.toString()}"
    }
}
