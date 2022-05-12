package com.vishnevskiypro.fragmentneco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.vishnevskiypro.fragmentneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(BlankFragment1.newInstance(), R.id.placeHolder)
        openFrag(BlankFragment2.newInstance(), R.id.placeHolder2)
        dataModel.messageForActivity.observe(this) {
            binding.textView.text = it
        }
    }

    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}