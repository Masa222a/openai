package com.example.openai

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.openai.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

//        viewModel.data.observe(viewLifecycleOwner) {
//            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
//        }
//
        binding.button.setOnClickListener {
            viewModel.getData()
            Log.d("imageLog", "$it")
        }

        return binding.root
    }

}

