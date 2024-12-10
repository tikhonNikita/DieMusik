package com.nikitaTikhonov.diemusik.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nikitaTikhonov.diemusik.DieMusikApplication
import com.nikitaTikhonov.diemusik.R
import com.nikitaTikhonov.diemusik.databinding.FragmentOnboardingBinding
import com.nikitaTikhonov.diemusik.viewmodel.OnboardingViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private lateinit var onboardingViewModel: OnboardingViewModel

    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().application as DieMusikApplication)
            .appComponent
            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        onboardingViewModel = ViewModelProvider(this, viewModelFactory)[OnboardingViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameInput.hint = getString(R.string.onboarding_placeholder_name)
        binding.nameInput.doOnTextChanged { text, _, _, _ ->
            onboardingViewModel.updateUserName(text.toString())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            onboardingViewModel.userName.collect { name ->
                binding.onboardingGivenName.text = name
            }
        }

        binding.onboardingToToMainFragmentButton.setOnClickListener {
            goToMainFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToMainFragment() {
        findNavController().navigate(R.id.action_onboardingFragment_to_mainFragment)
    }
}