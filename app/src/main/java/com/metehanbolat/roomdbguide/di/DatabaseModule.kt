package com.metehanbolat.roomdbguide.di

import android.content.Context
import androidx.room.Room
import com.metehanbolat.roomdbguide.database.UserDao
import com.metehanbolat.roomdbguide.databasewithdi.UserDatabaseWithDI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UserDatabaseWithDI =
        Room.databaseBuilder(
            context,
            UserDatabaseWithDI::class.java,
            "user_database_di"
        ).build()

    @Provides
    fun provideProductDao(databaseWithDI: UserDatabaseWithDI): UserDao = databaseWithDI.userDao()

}