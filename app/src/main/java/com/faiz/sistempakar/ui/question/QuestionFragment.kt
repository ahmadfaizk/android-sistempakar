package com.faiz.sistempakar.ui.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.faiz.sistempakar.R
import com.faiz.sistempakar.helpers.DataHelper
import com.faiz.sistempakar.model.Question
import com.faiz.sistempakar.ui.result.ResultFragment
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    private lateinit var adapter: QuestionAdapter

    companion object {
        private const val STATE = "state"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = QuestionAdapter()
        rv_questions.layoutManager = LinearLayoutManager(context)
        rv_questions.adapter = adapter

        val listQuestion: ArrayList<Question>? = if (savedInstanceState != null) {
            savedInstanceState.getParcelableArrayList(STATE)
        } else {
            DataHelper.getListQuestion()
        }
        if (listQuestion != null) {
            adapter.setListQuestions(listQuestion)
        }

        btnNext.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList(ResultFragment.EXTRA_QUESTIONS, adapter.getListQuestions())
            it.findNavController().navigate(R.id.action_questionFragment_to_resultFragment, bundle)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(STATE, adapter.getListQuestions())
    }
}
