package com.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fragment.R
import com.fragment.databinding.FragmentSignupBinding


class FragmentSignUp:Fragment() {
    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.inflate(R.layout.fragment_signup,container,false)
        binding=FragmentSignupBinding.inflate(inflater)
        return binding.root
    }




}