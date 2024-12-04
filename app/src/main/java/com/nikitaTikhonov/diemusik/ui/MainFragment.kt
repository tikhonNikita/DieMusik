package com.nikitaTikhonov.diemusik.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nikitaTikhonov.diemusik.DieMusikApplication
import com.nikitaTikhonov.diemusik.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment() {


    @Inject
    lateinit var message: String

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as DieMusikApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainTextView.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}