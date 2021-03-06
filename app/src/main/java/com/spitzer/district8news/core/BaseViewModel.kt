package com.spitzer.district8news.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spitzer.district8news.core.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    protected val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    protected val _snackbarError = MutableLiveData<Event<Int>>()
    val snackbarError: LiveData<Event<Int>> = _snackbarError

    protected val _loading = MutableLiveData<Event<Boolean>>()
    val loading: LiveData<Event<Boolean>> = _loading

}
