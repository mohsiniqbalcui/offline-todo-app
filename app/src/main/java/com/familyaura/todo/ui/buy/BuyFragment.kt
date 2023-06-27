package com.familyaura.todo.ui.buy

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
import com.familyaura.carer.databinding.FragmentBuyBinding
import com.familyaura.todo.adapters.BuyListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BuyFragment : Fragment() {

    private lateinit var buyListAdapter: BuyListAdapter
    private lateinit var buyViewModel: BuyViewModel
    private var _binding: FragmentBuyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBuyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeData()

    }

    private fun init() {
        buyViewModel =
            ViewModelProvider(this)[BuyViewModel::class.java]
        lifecycleScope.launch(Dispatchers.IO) {
            buyViewModel.getBuyData()
        }

    }

    private fun observeData() {
        binding?.buyRv?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL

        buyViewModel.buyData.observe(viewLifecycleOwner) {

            if (it.isNotEmpty()) {
                it?.let {
                    buyListAdapter = BuyListAdapter(
                        requireActivity(),
                        it
                    )

                    binding?.buyRv?.adapter = buyListAdapter
                }

            } else {
                Log.d("TAG", "Buy List is null")
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}