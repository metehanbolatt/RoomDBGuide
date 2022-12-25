package com.metehanbolat.roomdbguide.repository

import com.metehanbolat.roomdbguide.database.User
import com.metehanbolat.roomdbguide.database.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun readAllData() = userDao.readAllData()
    val readAllDataLikeLiveData = userDao.readAllDataLikeLiveData()
    suspend fun addUser(user: User) = userDao.addUser(user)
}