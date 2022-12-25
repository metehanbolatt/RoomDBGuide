package com.metehanbolat.roomdbguide

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.metehanbolat.roomdbguide.database.User
import com.metehanbolat.roomdbguide.database.UserDatabase
import com.metehanbolat.roomdbguide.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = UserDatabase.getDatabase(application).userDao()
    private val repository: UserRepository get() = UserRepository(userDao)
    val readAllDataLikeLiveData: LiveData<List<User>> = repository.readAllDataLikeLiveData

    private val _readAllData = MutableLiveData<List<User>>()
    val readAllData: LiveData<List<User>> = _readAllData

    init {
        readAllData()
    }

    private fun readAllData() = viewModelScope.launch(Dispatchers.IO) {
        _readAllData.postValue(repository.readAllData())
    }

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(user)
    }
}