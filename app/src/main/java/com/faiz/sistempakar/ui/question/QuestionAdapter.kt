package com.faiz.sistempakar.ui.question

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faiz.sistempakar.R
import com.faiz.sistempakar.model.Question
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    private val listQuestions = ArrayList<Question>()

    fun setListQuestions(listQuestion: ArrayList<Question>) {
        if (listQuestions.isNotEmpty()) {
            listQuestions.clear()
        }
        listQuestions.addAll(listQuestion)
        notifyDataSetChanged()
    }

    fun getListQuestions(): ArrayList<Question> {
        return listQuestions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listQuestions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listQuestions[position])
        holder.itemView.check_question.setOnCheckedChangeListener { _, isChecked ->
            listQuestions[position].checked = isChecked
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(question: Question) {
            with(itemView) {
                tv_question.text = question.text
                check_question.isChecked = question.checked
                itemView.setOnClickListener{
                    check_question.isChecked = !check_question.isChecked
                }
            }
        }
    }
}