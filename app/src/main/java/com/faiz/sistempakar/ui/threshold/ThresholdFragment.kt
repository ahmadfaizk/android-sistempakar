package com.faiz.sistempakar.ui.threshold

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController

import com.faiz.sistempakar.R
import com.faiz.sistempakar.ui.result.ResultFragment
import kotlinx.android.synthetic.main.fragment_threshold.*
import java.lang.NumberFormatException

/**
 * A simple [Fragment] subclass.
 */
class ThresholdFragment : Fragment() {

    private var threshold: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_threshold, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext.setOnClickListener {
            if (checkInput()) {
                val bundle = Bundle()
                bundle.putInt(ResultFragment.EXTRA_THRESHOLD, threshold)
                it.findNavController().navigate(R.id.action_thresholdFragment_to_questionFragment, bundle)
            }
        }
    }

    private fun checkInput() : Boolean {
        var ready = true
        val textNumber = edt_threshold.text.toString()
        try {
            threshold = textNumber.toInt()
        } catch (e: NumberFormatException) {
            edt_threshold.error = "Nilai Threshold Harus Angka"
            ready = false
        }
        if (threshold < 1 || threshold > 100) {
            edt_threshold.error = "Nilai Threshold Harus 1-100"
            ready = false
        }
        return ready
    }
}
