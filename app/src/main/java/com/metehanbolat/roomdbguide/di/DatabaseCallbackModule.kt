package com.metehanbolat.roomdbguide.di

import android.content.Context
import androidx.room.Room
import com.metehanbolat.roomdbguide.databasewithcallbackdi.UserDatabaseWithCallbackDI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseCallbackModule {

    @Provides
    fun provideDatabaseWithCallback(
        @ApplicationContext context: Context,
        callback: UserDatabaseWithCallbackDI.Callback
    ) = Room.databaseBuilder(
        context,
        UserDatabaseWithCallbackDI::class.java,
        "user_database_with_callback"
    )
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideUserDao(database: UserDatabaseWithCallbackDI) = database.userDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope