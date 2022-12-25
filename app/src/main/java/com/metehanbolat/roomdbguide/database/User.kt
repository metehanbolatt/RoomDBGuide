package com.metehanbolat.roomdbguide.database

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val profilePhoto: Bitmap,
    @Embedded
    val parent: Parent
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

data class Parent(
    val motherName: String,
    val fatherName: String
)
