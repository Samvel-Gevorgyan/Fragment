package com.fragment

import androidx.fragment.app.Fragment

interface Communicator {
    fun transaction(fragment: Fragment)
    fun transactionData(userName: String,userPassword:String)
}