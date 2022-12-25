package com.metehanbolat.roomdbguide.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    suspend fun readAllData(): List<User>

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllDataLikeLiveData(): LiveData<List<User>>

}