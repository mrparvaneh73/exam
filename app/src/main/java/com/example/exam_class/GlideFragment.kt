package com.example.exam_class

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.exam_class.databinding.FragmentGlideBinding
import kotlinx.android.synthetic.main.fragment_glide.*

class GlideFragment:Fragment() {
    private  lateinit var binding: FragmentGlideBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding=DataBindingUtil.inflate(inflater,R.layout.fragment_glide,container,false)
        return binding.root
    }


}