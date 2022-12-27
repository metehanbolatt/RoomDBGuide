package com.metehanbolat.roomdbguide.multipletable.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.metehanbolat.roomdbguide.multipletable.model.Director
import com.metehanbolat.roomdbguide.multipletable.model.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)