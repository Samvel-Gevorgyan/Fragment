package com.fragment.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fragment.Communicator
import com.fragment.R
import com.fragment.databinding.FragmentWelcomeBinding

import com.loginsignup.constance.Constance



class FragmentWelcome : Fragment() {

    private lateinit var communicator: Communicator
    private lateinit var binding: FragmentWelcomeBinding
    private val fragmentLogIn = FragmentLogIn()
    private val fragmentSignUp = FragmentSignUp()
    private var userName: String? = ""
    private var userPassword: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.inflate(R.layout.fragment_welcome, container, false)
        binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicator = activity as Communicator

        binding.buttonLogIn.setOnClickListener {
            communicator.transaction(fragmentLogIn)
        }

        binding.buttonSignUp.setOnClickListener {
            communicator.transaction(fragmentSignUp)
        }

        userName = arguments?.getString(Constance.KEY_USER_NAME)
        userPassword = arguments?.getString(Constance.KEY_USER_PASSWORD)

        binding.getT.text=userName.toString()
        binding.getP.text=userPassword.toString()

    }


    private fun createDialog(context: Context, userName: String, userPassword: String) {
        val dialog = Dialog(context)

        dialog.setContentView(R.layout.dialog_login)
        val userNameDialog = dialog.findViewById<TextView>(R.id.userName_dialog)
        val userPasswordDialog = dialog.findViewById<TextView>(R.id.userPassword_dialog)

        userNameDialog.text = userName
        userPasswordDialog.text = userPassword

        dialog.show()
    }


}