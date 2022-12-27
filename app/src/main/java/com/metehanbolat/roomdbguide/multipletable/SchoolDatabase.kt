package com.metehanbolat.roomdbguide.multipletable

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.metehanbolat.roomdbguide.multipletable.dao.SchoolDao
import com.metehanbolat.roomdbguide.multipletable.model.Director
import com.metehanbolat.roomdbguide.multipletable.model.School
import com.metehanbolat.roomdbguide.multipletable.model.Student
import com.metehanbolat.roomdbguide.multipletable.model.Subject
import com.metehanbolat.roomdbguide.multipletable.relations.StudentSubjectCrossRef

@Database(
    entities = [School::class, Student::class, Director::class, Subject::class, StudentSubjectCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }

    }
}