package com.vishnevskiypro.fragmentneco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.vishnevskiypro.fragmentneco.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {
    lateinit var binding: FragmentBlank2Binding
    private val  dataModel : DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })

        binding.buttonSendToFrag1.setOnClickListener{
            dataModel.messageForFrag1.value = "Hello from fragment 2"
        }
        binding.buttonSendToActivityFrag2.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 2"
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}