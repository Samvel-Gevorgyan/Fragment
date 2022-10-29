package com.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.fragment.Communicator
import com.fragment.R
import com.fragment.databinding.FragmentLoginBinding


class   FragmentLogIn : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var communicator: Communicator


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        communicator = activity as Communicator

        binding.buttonLogIn.setOnClickListener {
            communicator.transactionData(binding.editTextUserName.text.toString(),binding.editTextPassword.text.toString())
        }
        binding.buttonBack.setOnClickListener{
            val fragmentWelcome=FragmentWelcome()
            communicator.transaction(fragmentWelcome)
        }



    }


}







