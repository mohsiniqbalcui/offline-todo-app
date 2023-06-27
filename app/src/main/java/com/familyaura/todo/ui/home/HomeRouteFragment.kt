package com.familyaura.todo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.familyaura.carer.R
import com.familyaura.carer.databinding.FragmentHomeRouteBinding

class HomeRouteFragment : Fragment() {

    companion object {
        fun newInstance() = HomeRouteFragment()
    }

    private lateinit var viewModel: HomeRouteViewModel

    private var _binding: FragmentHomeRouteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeRouteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeRouteViewModel::class.java]
        initView()
    }

    private fun initView() {

        binding.btnBuy.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_buyFragment)
        }

        binding.btnCall.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_callFragment)
        }

        binding.btnSell.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_sellFragment)
        }
    }


}