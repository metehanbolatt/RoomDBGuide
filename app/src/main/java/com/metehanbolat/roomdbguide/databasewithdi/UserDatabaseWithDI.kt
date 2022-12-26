package com.metehanbolat.roomdbguide.databasewithdi

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.metehanbolat.roomdbguide.database.Converters
import com.metehanbolat.roomdbguide.database.User
import com.metehanbolat.roomdbguide.database.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UserDatabaseWithDI: RoomDatabase() {

    abstract fun userDao(): UserDao
}