package com.example.latihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val btnKali = view.findViewById<Button>(R.id.btnKali)
        val btnBagi = view.findViewById<Button>(R.id.btnBagi)

        btnKali.setOnClickListener { hitungOperasi("*") }
        btnBagi.setOnClickListener { hitungOperasi("/") }

        return view
    }

    private fun hitungOperasi(operasi: String) {
        val angka1 = activity?.findViewById<EditText>(R.id.txAngka1)?.text.toString().toIntOrNull() ?: 0
        val angka2 = activity?.findViewById<EditText>(R.id.txAngka2)?.text.toString().toIntOrNull() ?: 0

        val hasil = when (operasi) {
            "*" -> angka1 * angka2
            "/" -> if (angka2 != 0) angka1 / angka2 else 0
            else -> 0
        }

        val fragment2 = Fragment2.newInstance("$angka1 $operasi $angka2 = $hasil")

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer, fragment2)
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}