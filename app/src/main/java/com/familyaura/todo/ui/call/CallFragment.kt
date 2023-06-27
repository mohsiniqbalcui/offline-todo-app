package com.familyaura.todo.ui.call

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.familyaura.todo.adapters.CallListAdapter
import com.familyaura.carer.databinding.FragmentCallBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CallFragment : Fragment() {

    private var _binding: FragmentCallBinding? = null
    private lateinit var callViewModel: CallViewModel
    private lateinit var callListAdapter: CallListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCallBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeData()

    }

    private fun init() {
        callViewModel =
            ViewModelProvider(this)[CallViewModel::class.java]
        lifecycleScope.launch(Dispatchers.IO) {
            callViewModel.getCallData()
        }

    }

    private fun observeData() {
        binding?.callRv?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL

        callViewModel.callData.observe(viewLifecycleOwner) {

            if (it.isNotEmpty()) {
                it?.let {
                callListAdapter = CallListAdapter(
                        requireActivity(),
                        it
                    )

                    binding?.callRv?.adapter = callListAdapter
                }

            } else {
                Log.d("TAG", "call List is null")
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}