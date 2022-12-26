package com.metehanbolat.roomdbguide.databasewithcallbackdi

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.metehanbolat.roomdbguide.database.Converters
import com.metehanbolat.roomdbguide.database.Parent
import com.metehanbolat.roomdbguide.database.User
import com.metehanbolat.roomdbguide.database.UserDao
import com.metehanbolat.roomdbguide.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UserDatabaseWithCallbackDI: RoomDatabase() {

    abstract fun userDao(): UserDao

    class Callback @Inject constructor(
        private val database: Provider<UserDatabaseWithCallbackDI>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().userDao()

            applicationScope.launch {
                dao.addUser(User("Metehan", "Bolat", 24, parent = Parent(motherName = "X", "Y")))
            }

        }
    }
}