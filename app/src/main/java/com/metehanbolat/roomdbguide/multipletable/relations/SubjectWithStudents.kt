package com.metehanbolat.roomdbguide.multipletable.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.metehanbolat.roomdbguide.multipletable.model.Student
import com.metehanbolat.roomdbguide.multipletable.model.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students : List<Student>
)
