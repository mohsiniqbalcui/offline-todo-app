package com.familyaura.todo.ui.sell

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.familyaura.carer.databinding.FragmentSellBinding
import com.familyaura.todo.adapters.BuyListAdapter

class SellFragment : Fragment() {

    private lateinit var buyListAdapter: BuyListAdapter
    private lateinit var sellViewModel: SellViewModel
    private var _binding: FragmentSellBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSellBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeData()
    }

    private fun init() {
        sellViewModel =
            ViewModelProvider(this)[SellViewModel::class.java]
    }

    private fun observeData() {

        binding?.sellRv?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL

        sellViewModel.sellData.observe(viewLifecycleOwner) {

            if (it.isNotEmpty()) {
                it?.let {
                    buyListAdapter = BuyListAdapter(
                        requireActivity(),
                        it
                    )

                    binding?.sellRv?.adapter = buyListAdapter
                }

            } else {
                Log.d("TAG", "sell List is null")
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}