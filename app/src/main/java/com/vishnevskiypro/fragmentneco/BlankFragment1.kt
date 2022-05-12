package com.vishnevskiypro.fragmentneco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.vishnevskiypro.fragmentneco.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {
    private val  dataModel : DataModel by activityViewModels()
    lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {
            binding.textViewFrag1.text = it
        })

        binding.buttonSendToFrag2.setOnClickListener{
            dataModel.messageForFrag2.value = "Hello from fragment 1"
        }
        binding.buttonSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment1()
    }
}