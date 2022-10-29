package com.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.loginsignup.constance.Constance
import com.fragment.fragment.FragmentWelcome

class MainActivity : AppCompatActivity(),Communicator {
    private val fragmentWelcome = FragmentWelcome()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, fragmentWelcome).commit()

    }
    override fun transaction(fragment: Fragment) {
        val transaction=this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    override fun transactionData(userName: String, userPassword: String) {

        val bundle = Bundle()
        bundle.putString(Constance.KEY_USER_NAME,userName)
        bundle.putString(Constance.KEY_USER_PASSWORD,userPassword)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentWelcome= FragmentWelcome()
        fragmentWelcome.arguments = bundle
        transaction.replace(R.id.container, fragmentWelcome)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

}


