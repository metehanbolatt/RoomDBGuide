package com.metehanbolat.roomdbguide.multipletable.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.metehanbolat.roomdbguide.multipletable.model.School
import com.metehanbolat.roomdbguide.multipletable.model.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)