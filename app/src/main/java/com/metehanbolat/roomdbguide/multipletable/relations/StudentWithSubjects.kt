package com.metehanbolat.roomdbguide.multipletable.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.metehanbolat.roomdbguide.multipletable.model.Student
import com.metehanbolat.roomdbguide.multipletable.model.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subject: List<Subject>
)
