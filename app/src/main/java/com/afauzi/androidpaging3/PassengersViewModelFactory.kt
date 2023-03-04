package com.afauzi.androidpaging3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PassengersViewModelFactory(private val api: MyApi): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PassengersViewModel(api) as T
    }
}