package com.example.checkconsumo29121

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.checkconsumo29121.databinding.FragmentFirstBinding
import com.example.checkconsumo29121.model.Consumption

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: ConViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = ConAdapter()
        binding.rvCon.adapter = adapter
        binding.rvCon.layoutManager = LinearLayoutManager(context)

        viewModel.allConsumption.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.selected(it)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })




    }
}